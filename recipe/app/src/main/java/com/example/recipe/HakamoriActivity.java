package com.example.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class HakamoriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakamori);

        HashMap<String, String> ings = new HashMap<>();
        ings.put("ごはん", "茶碗一杯");
        ings.put("卵", "1個");
        ings.put("しょうゆ", "大匙1");
        DBHandler dbHandler = new DBHandler(HakamoriActivity.this);
        dbHandler.addNewRecipe("卵かけごはん", ings, "ごはんをよそう。卵をかける。醤油をかける。");

        RecipeModel r = dbHandler.getRecipe(1);
        Log.d("recipe_name", r.getRecipeName());
        Log.d("ingredients", r.getIngredients().toString());
        Log.d("description", r.getDescription());
        Log.d("count", String.valueOf(dbHandler.getCount()));
    }
}