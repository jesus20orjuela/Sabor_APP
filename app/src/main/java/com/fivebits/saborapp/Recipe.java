package com.fivebits.saborapp;

public class Recipe {
    private final int id;
    private final String name;
    private final String time;
    private final String ingredients;
    private final String procedure;

    public Recipe(int id, String name, String time, String ingredients, String procedure) {
        this.id = id; this.name = name; this.time = time;
        this.ingredients = ingredients; this.procedure = procedure;
    }
    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getTime(){ return time; }
    public String getIngredients(){ return ingredients; }
    public String getProcedure(){ return procedure; }
}
