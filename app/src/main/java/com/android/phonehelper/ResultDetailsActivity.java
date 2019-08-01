package com.android.phonehelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ResultDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.result_details_layout);
        String text = intent.getStringExtra("content");
        String videoUri = intent.getStringExtra("video");
        TextView content = findViewById(R.id.details_content);
        content.setText(text);
        final VideoView video = findViewById(R.id.details_video);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shipintonghua));
//        video.setVideoPath("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-33-30.mp4");
        MediaController controller = new MediaController(this);
        video.setMediaController(controller);
        video.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
