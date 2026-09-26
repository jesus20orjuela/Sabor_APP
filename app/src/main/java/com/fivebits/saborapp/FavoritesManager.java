package com.fivebits.saborapp;
import android.content.Context;
import android.content.SharedPreferences;

public class FavoritesManager {
    private final SharedPreferences prefs;
    public FavoritesManager(Context context){
        prefs = context.getSharedPreferences("sabor_favorites", Context.MODE_PRIVATE);
    }
    public boolean isFavorite(int recipeId){ return prefs.getBoolean("recipe_" + recipeId, false); }
    public void setFavorite(int recipeId, boolean value){
        prefs.edit().putBoolean("recipe_" + recipeId, value).apply();
    }
}
