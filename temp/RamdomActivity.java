package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RamdomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramdom);
        TextView textView_1 = (TextView) findViewById(R.id.textView_1);
        TextView textView_2 = (TextView) findViewById(R.id.textView_2);
        TextView textView_3 = (TextView) findViewById(R.id.textView_3);

        Intent intent = getIntent();
        int choice_num = intent.getIntExtra(MainActivity.choice, 0);

        textView_1.setText(String.valueOf(choice_num));
        textView_2.setText(String.valueOf(choice_num));
        textView_3.setText(String.valueOf(choice_num));
    }

    public void return_main(View view) {
        Intent intent = new Intent(getApplication(), MainActivity.class);

        //行く
        startActivity(intent);
    }
}