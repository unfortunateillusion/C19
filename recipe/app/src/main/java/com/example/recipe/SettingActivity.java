package com.example.recipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingActivity extends AppCompatActivity {

    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final EditText editText21 = (EditText)findViewById(R.id.editText21);
        final EditText editText22 = (EditText)findViewById(R.id.editText22);
        final List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Button saveButton = (Button)findViewById(R.id.save_button);
        Button clearButton = (Button)findViewById(R.id.clear_button);
        ListView listView = (ListView)findViewById(R.id.list);


        adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,new String[]{"ingredients","amount"}, new int[]{android.R.id.text1,android.R.id.text2});
        listView.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //エディタの内容を取得
                String ingredients = editText21.getText().toString();
                String amount = editText22.getText().toString();

                //材料が入力されてない場合は保存しない
                if(ingredients.isEmpty()){
                    Toast.makeText(getApplicationContext(),"材料が入力されていません",Toast.LENGTH_SHORT).show();
                    return;
                }

                //リストに材料を反映
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ingredients", ingredients);
                map.put("amount",amount);
                list.add(map);
                listView.setAdapter(adapter);


                //エディタをクリア
                editText21.setText("");
                editText22.setText("");
            }
        });

        //取り消しボタンの操作
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //エディタに文字をセットする
                editText21.setText("");
                //editText22.setText("");
            }
        });

    }


    public void Register2(View view) {
        //DBにつなげる?
    }

    //アクティビティを閉じる
    public void onClose(View view) {
        finish();
    }
}