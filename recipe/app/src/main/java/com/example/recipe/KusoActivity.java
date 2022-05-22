package com.example.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class KusoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuso);
    }

    public void Random_Output(View view) {
        Intent intent = new Intent(getApplication(), RamdomActivity.class);

        Random rand = new Random();
        int num = rand.nextInt(dbHandler.getCount());
        intent.putExtra("choice", num + 1);

        intent.putExtra("Where_from", "main");

        //行く
        startActivity(intent);
    }

    public void list_Output(View view) {
        Intent intent = new Intent(getApplication(), ListActivity.class);

        //行く
        startActivity(intent);
    }
}