package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Random_Output(View view) {
        Intent intent = new Intent(getApplication(), RamdomActivit.class);

        Random rand = new Random();
        int num = rand.nextInt(10);

        intent.putExtra(choice, num);

        //行く
        startActivity(intent);
    }
}