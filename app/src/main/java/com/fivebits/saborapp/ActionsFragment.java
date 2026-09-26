package com.fivebits.saborapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.List;
import java.util.Random;

public class ActionsFragment extends Fragment {
    private int portions = 4;
    private boolean favorite = false;
    private TextView portionsLabel, calculated;
    private Button favoriteButton;

    public ActionsFragment(){ super(R.layout.fragment_actions); }

    @Override public void onViewCreated(@NonNull View v, Bundle savedInstanceState){
        portionsLabel = v.findViewById(R.id.txtPortions);
        calculated = v.findViewById(R.id.txtCalculated);
        favoriteButton = v.findViewById(R.id.btnFavorite);
        refresh();

        v.findViewById(R.id.btnMinus).setOnClickListener(x -> { if(portions > 1) portions--; refresh(); });
        v.findViewById(R.id.btnPlus).setOnClickListener(x -> { if(portions < 20) portions++; refresh(); });

        favoriteButton.setOnClickListener(x -> {
            favorite = !favorite;
            favoriteButton.setText(favorite ? "★ Quitar receta base de favoritos" : "☆ Guardar receta base en favoritos");
            Toast.makeText(requireContext(), favorite ? "Guardada en favoritos" : "Eliminada de favoritos", Toast.LENGTH_SHORT).show();
        });

        v.findViewById(R.id.btnRandom).setOnClickListener(x -> {
            List<Recipe> recipes = RecipeRepository.all();
            Recipe r = recipes.get(new Random().nextInt(recipes.size()));
            Toast.makeText(requireContext(), "Receta aleatoria: " + r.getName(), Toast.LENGTH_LONG).show();
            ((MainActivity)requireActivity()).showRecipe(r.getId());
        });

        v.findViewById(R.id.btnShare).setOnClickListener(x -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, "SaborApp · Ajiaco santafereño para " + portions + " porciones.");
            startActivity(Intent.createChooser(i, "Compartir receta"));
        });

        v.findViewById(R.id.btnClear).setOnClickListener(x -> {
            portions = 4; favorite = false;
            favoriteButton.setText("☆ Guardar receta base en favoritos");
            refresh();
            Toast.makeText(requireContext(), "Contenido restablecido", Toast.LENGTH_SHORT).show();
        });
    }

    private void refresh(){
        portionsLabel.setText(String.valueOf(portions));
        double factor = portions / 4.0;
        calculated.setText("Resultado para " + portions + " porciones\n\n"
                + "Pollo: " + Math.round(500 * factor) + " g\n"
                + "Papa: " + Math.round(1200 * factor) + " g\n"
                + "Mazorca: " + Math.max(1, Math.round(2 * factor)) + "\n"
                + "Guascas: " + Math.round(30 * factor) + " g");
    }
}
