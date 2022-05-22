package com.example.test;

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
        int choice_num = intent.getIntExtra("choice", 11);

        textView_1.setText(String.valueOf(choice_num));
        textView_2.setText(String.valueOf(choice_num));
        textView_3.setText(String.valueOf(choice_num));


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

        HashMap<String, String> ings = new HashMap<>();
        ings.put("ごはん", "茶碗一杯");
        ings.put("卵", "1個");
        ings.put("しょうゆ", "大匙1");
        DBHandler dbHandler = new DBHandler(RamdomActivity.this);
        dbHandler.addNewRecipe("卵かけごはん", ings, "ごはんをよそう。卵をかける。醤油をかける。");

        RecipeModel r = dbHandler.getRecipe(1);
        Log.d("recipe_name", r.getRecipeName());
        Log.d("ingredients", r.getIngredients().toString());
        Log.d("description", r.getDescription());
        Log.d("count", String.valueOf(dbHandler.getCount()));

        //行く
        startActivity(intent);
    }
}