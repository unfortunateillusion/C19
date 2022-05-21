package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RamdomActivit extends AppCompatActivity {

    private int choice_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramdom);
        TextView textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        choice_num = intent.getIntExtra(MainActivity.choice, 0);

        textView.setText(String.valueOf(choice_num));
    }
}