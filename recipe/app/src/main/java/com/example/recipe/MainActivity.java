package com.example.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        //行く
    public void callHakamori(View view) {
        Intent intent = new Intent(this, HakamoriActivity.class);
        startActivity(intent);
    }

    public void callKuso(View view) {
        Intent intent = new Intent(this, KusoActivity.class);
        startActivity(intent);
    }

    public void callKishioka(View view) {
        Intent intent = new Intent(this, KishiokaActivity.class);
        startActivity(intent);
    }
}