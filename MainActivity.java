package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
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
                    if (item.getKeywords().equals(content)) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "授权失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
                startService(new Intent(MainActivity.this, FloatingService.class));
            }
        }
    }

    private List<ResultItem> dataInit(){
        List<ResultItem> dataset = new ArrayList<>();
        //数据存储逻辑
        dataset.add(new ResultItem(getString(R.string.keywords1), getString(R.string.desc1), getString(R.string.video1)));
        dataset.add(new ResultItem(getString(R.string.keywords2), getString(R.string.desc2), getString(R.string.video2)));
        dataset.add(new ResultItem(getString(R.string.keywords3), getString(R.string.desc3), getString(R.string.video3)));
        return dataset;
    }

    public void startFloatingButtonService() {
        if (FloatingService.isStarted) {
            return;
        }
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        } else {
            startService(new Intent(MainActivity.this, FloatingService.class));
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        startFloatingButtonService();
    }
}
