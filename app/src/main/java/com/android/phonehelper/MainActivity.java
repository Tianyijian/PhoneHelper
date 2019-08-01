package com.android.phonehelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.search_button);
        final EditText parameter = findViewById(R.id.search_what);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String content = parameter.getText().toString();
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
            }
        });
        RecyclerView result = findViewById(R.id.search_result);
        List<ResultItem> itemList = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.shipintonghua;

//        String uri = "https://www.w3school.com.cn//i/movie.ogg";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 50; j++){
                builder.append("第");
                builder.append(j);
                builder.append("个");
            }
            itemList.add(new ResultItem(builder.toString(), uri));
            builder.setLength(0);
        }
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        result.setLayoutManager(layoutManager);
        ResultAdapter adapter = new ResultAdapter(itemList, this);
        result.setAdapter(adapter);
    }
}
