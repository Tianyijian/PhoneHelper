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

    private RecyclerView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<ResultItem> dataset = dataInit();
        Button button = findViewById(R.id.search_button);
        final EditText parameter = findViewById(R.id.search_what);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String content = parameter.getText().toString();
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_LONG).show();
                List<ResultItem> searchResult = new ArrayList<>();
                for(ResultItem item : dataset){
                    if (item.getKeywords().contains(content)) {
                        searchResult.add(item);
                    }
                }
                ResultAdapter adapter = new ResultAdapter(searchResult, MainActivity.this);
                result.setAdapter(adapter);
            }
        });
        result = findViewById(R.id.search_result);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        result.setLayoutManager(layoutManager);
        ResultAdapter adapter = new ResultAdapter(dataset, this);
        result.setAdapter(adapter);
    }

    private List<ResultItem> dataInit(){
        List<ResultItem> dataset = new ArrayList<>();
        //数据存储逻辑
        dataset.add(new ResultItem(getString(R.string.keywords1), getString(R.string.desc1), R.raw.red_packet, R.drawable.red_packet));
        dataset.add(new ResultItem(getString(R.string.keywords2), getString(R.string.desc2), R.raw.video, R.drawable.video));
        dataset.add(new ResultItem(getString(R.string.keywords3), getString(R.string.desc3), R.raw.emoji, R.drawable.emoji));
        return dataset;
    }

}
