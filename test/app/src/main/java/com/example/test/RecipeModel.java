package com.example.test;

        import java.util.HashMap;

public class RecipeModel {
    private int id;
    private String recipeName;
    private HashMap<String, String> ingredients;
    private String description;

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public HashMap<String, String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public RecipeModel(int id, String recipeName, String description) {
        this.id = id;
        this.recipeName = recipeName;
        this.description = description;
        this.ingredients = new HashMap<String, String>();
    }
}
