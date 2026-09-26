package com.fivebits.saborapp;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecipesFragment extends Fragment {
    public RecipesFragment(){ super(R.layout.fragment_recipes); }

    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        RecyclerView rv = view.findViewById(R.id.rvRecipes);
        rv.setLayoutManager(new LinearLayoutManager(requireContext()));
        rv.setAdapter(new RecipeAdapter(RecipeRepository.all(),
                recipe -> ((MainActivity)requireActivity()).showRecipe(recipe.getId())));
    }
}
