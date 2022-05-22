package com.example.recipe;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "RecipeDB.db";
    private static final int DB_VERSION = 1;

    public DBHandler(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String recipesQuery = "CREATE TABLE IF NOT EXISTS " + "recipes" + " ("
                + "recipe_id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "recipe_name" + " TEXT, "
                + "description" + " TEXT)";

        String ingredientsQuery = "CREATE TABLE IF NOT EXISTS " + "ingredients" + " ("
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "recipe_name" + " TEXT, "
                + "ingredient_name" + " TEXT, "
                + "amount" + " TEXT, "
                + "FOREIGN KEY (" + "recipe_name" + ") REFERENCES " + "recipes (recipe_name))";

        db.execSQL(recipesQuery);
        db.execSQL(ingredientsQuery);
    }

    public void addNewRecipe(String recipeName, HashMap<String, String> ingredients, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("recipe_name", recipeName);
        values.put("description", description);
        db.insert("recipes", null, values);
        values.clear();

        ingredients.forEach((key, value) -> {
            values.put("ingredient_name", key);
            values.put("amount", value);
            values.put("recipe_name", recipeName);
            db.insert("ingredients", null, values);
            values.clear();
        });

        db.close();
    }

    public int getCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(recipe_name) FROM recipes", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count;
    }

    public RecipeModel getRecipe(int id) {
        RecipeModel r;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT recipes.recipe_id, recipes.recipe_name, recipes.description, ingredients.ingredient_name, ingredients.amount FROM recipes INNER JOIN ingredients ON recipes.recipe_name = ingredients.recipe_name WHERE recipes.recipe_id = " + id , null);
        cursor.moveToFirst();
        r = new RecipeModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
        do {
            r.getIngredients().put(cursor.getString(3), cursor.getString(4));
        } while (cursor.moveToNext());
        cursor.close();
        return r;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}