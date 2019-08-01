package com.android.phonehelper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.MediaController;
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
        int videoUri = intent.getIntExtra("video", -1);
//        TextView content = findViewById(R.id.details_content);
//        content.setText(text);
        WebView content = findViewById(R.id.html);
        if (text.equals(getString(R.string.desc1))) {
            content.loadUrl("file:///android_asset/hongbao.html");
        } else if (text.equals(getString(R.string.desc2))) {
            content.loadUrl("file:///android_asset/tonghua.html");
        } else if (text.equals(getString(R.string.desc3))) {
            content.loadUrl("file:///android_asset/biaoqing.html");
        } else {
            Log.e("ERROR", "onCreate: ");
        }


        final VideoView video = findViewById(R.id.details_video);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoUri));
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
