package com.example.resipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // ListViewに表示する項目をで準備する
        ArrayList data = new ArrayList<>();

        data.add("test");
        data.add("test2");

        // リスト項目とListViewを対応付けるArrayAdapterを用意する
        ArrayAdapter adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, data);

        // ListViewにArrayAdapterを設定する
        ListView listView_1 = findViewById(R.id.listView);
        listView_1.setAdapter(adapter);

        listView_1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = position + "番目のアイテムがクリックされました";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplication(), RamdomActivity.class);

                intent.putExtra("Where_from", "List");


                intent.putExtra("choice", position);

                //行く
                startActivity(intent);
            }
        });
    }


    public void return_main(View view)
    {
        Intent intent = new Intent(getApplication(), MainActivity.class);

        //行く
        startActivity(intent);
    }
}