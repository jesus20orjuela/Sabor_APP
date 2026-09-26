package com.fivebits.saborapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.menuContainer, new MenuFragment())
                    .replace(R.id.contentContainer, new ProfileFragment())
                    .commit();
        }
    }
    public void showContent(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();
    }
    public void showRecipe(int recipeId){
        showContent(RecipeDetailFragment.newInstance(recipeId));
    }
}
