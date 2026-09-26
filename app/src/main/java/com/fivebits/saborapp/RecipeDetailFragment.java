package com.fivebits.saborapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RecipeDetailFragment extends Fragment {
    private static final String ARG_ID = "recipe_id";
    private Recipe recipe;
    private FavoritesManager favorites;

    public RecipeDetailFragment(){ super(R.layout.fragment_recipe_detail); }

    public static RecipeDetailFragment newInstance(int id){
        RecipeDetailFragment f = new RecipeDetailFragment();
        Bundle b = new Bundle(); b.putInt(ARG_ID, id); f.setArguments(b);
        return f;
    }

    @Override public void onViewCreated(@NonNull View v, Bundle savedInstanceState){
        int id = getArguments() != null ? getArguments().getInt(ARG_ID, 1) : 1;
        recipe = RecipeRepository.byId(id);
        favorites = new FavoritesManager(requireContext());

        ((TextView)v.findViewById(R.id.txtDetailName)).setText(recipe.getName());
        ((TextView)v.findViewById(R.id.txtDetailTime)).setText(recipe.getTime());
        ((TextView)v.findViewById(R.id.txtIngredients)).setText(recipe.getIngredients());
        ((TextView)v.findViewById(R.id.txtProcedure)).setText(recipe.getProcedure());

        Button fav = v.findViewById(R.id.btnDetailFavorite);
        refreshFavorite(fav);
        fav.setOnClickListener(x -> {
            boolean next = !favorites.isFavorite(recipe.getId());
            favorites.setFavorite(recipe.getId(), next);
            refreshFavorite(fav);
            Toast.makeText(requireContext(), next ? "Receta guardada en favoritos" : "Receta eliminada de favoritos", Toast.LENGTH_SHORT).show();
        });

        v.findViewById(R.id.btnDetailShare).setOnClickListener(x -> share());
        v.findViewById(R.id.btnBackRecipes).setOnClickListener(x ->
                ((MainActivity)requireActivity()).showContent(new RecipesFragment()));
    }

    private void refreshFavorite(Button b){
        b.setText(favorites.isFavorite(recipe.getId()) ? "★ Quitar de favoritos" : "☆ Guardar en favoritos");
    }

    private void share(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, recipe.getName() + "\n\n" + recipe.getIngredients() + "\n\n" + recipe.getProcedure());
        startActivity(Intent.createChooser(i, "Compartir receta"));
    }
}
