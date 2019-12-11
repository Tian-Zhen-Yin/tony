package com.learn.lister.systemvediorecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import org.song.videoplayer.DemoQSVideoView;
import org.song.videoplayer.IVideoPlayer;
import org.song.videoplayer.PlayListener;

public class VideoActivity extends AppCompatActivity {
    DemoQSVideoView qsVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent = getIntent();
        String path=getIntent().getStringExtra("path");
        Log.e("Path",path);
        qsVideoView= (DemoQSVideoView) findViewById(R.id.video);
        //设置标题
        qsVideoView.setUp(path,"title");
        //设置封面
       /* qsVideoView.getCoverImageView().setImageResource(R.mipmap.ic_launcher);*/
        qsVideoView.setPlayListener(new PlayListener() {
            @Override
            public void onStatus(int status) {
                if (status == IVideoPlayer.STATE_AUTO_COMPLETE)
                    qsVideoView.quitWindowFullscreen();//播放完成退出全屏
            }

            @Override
            public void onMode(int mode) {

            }

            @Override
            public void onEvent(int what, Integer... extra) {

            }
        });
        qsVideoView.enterFullMode=3;
        qsVideoView.play();
    }
    @Override
    public void onBackPressed() {
        if (qsVideoView.onBackPressed())
            return;
        super.onBackPressed();
    }
}
