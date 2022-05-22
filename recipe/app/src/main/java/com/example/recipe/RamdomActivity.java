package com.example.recipe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;

public class RamdomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramdom);
        TextView textView_1 = findViewById(R.id.textView_1);
        TextView textView_2 = findViewById(R.id.textView_2);
        TextView textView_3 = findViewById(R.id.textView_3);

        Intent intent = getIntent();
        int choice_num = intent.getIntExtra("choice", -1);

        DBHandler dbHandler = new DBHandler(RamdomActivity.this);

        Log.d("log", String.valueOf(choice_num));
        RecipeModel r = dbHandler.getRecipe(choice_num);
        //Log.d("recipe_name", r.getRecipeName());
        //Log.d("ingredients", r.getIngredients().toString());
        //Log.d("description", r.getDescription());
        //Log.d("count", String.valueOf(dbHandler.getCount()));
        textView_1.setText(r.getRecipeName());
        textView_2.setText(r.getIngredients().toString());
        textView_3.setText(r.getDescription());
    }

    public void return_main(View view) {
        Intent intent;
        Intent get_data = getIntent();

        String Return_to = get_data.getStringExtra("Where_from");

        if (Return_to.equals("List"))
        {
            intent = new Intent(getApplication(), ListActivity.class);
        }
        else
        {
            intent = new Intent(getApplication(), MainActivity.class);
        }

        //行く
        startActivity(intent);
    }
}