package com.example.jay.simplemusicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class Second extends AppCompatActivity{

    private MediaPlayer music;
    int[] songfile = new int[] {R.raw.m01,R.raw.m02,R.raw.m03,R.raw.m04,R.raw.m05};
    int current = 0;
    int[] imgID = {R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05};
    private Button pre, next, play, pause;
    private Button toHome;
    private ImageView photo;

    int p = 0;
    int len = imgID.length;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        toHome = (Button) findViewById(R.id.home);
        pre = (Button) findViewById(R.id.previous);
        next = (Button) findViewById(R.id.next);
        photo = (ImageView) findViewById(R.id.imageView);
        play = (Button) findViewById(R.id.cover);
        pause = (Button) findViewById(R.id.lyrics);

        toHome.setOnClickListener(toHomeListener);
        pre.setOnClickListener(preListener);
        next.setOnClickListener(nextListener);
        play.setOnClickListener(playListener);
        pause.setOnClickListener(pauseListener);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String num = bundle.getString("NUMBER");
        photo.setImageResource(imgID[Integer.parseInt(num)-1]);
        p = Integer.parseInt(num)-1;
        current = Integer.parseInt(num)-1;
        music = null;

        playSong(songfile[current]);

    }

    private void nextSong(){
        current++;
        if (current == len){
            current = 0;
        }
    }
    private void playSong(int song){

        if (music != null) {
            music.reset();
            music = null;
        }
        music = MediaPlayer.create(Second.this, song);
        music.start();

        music.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                nextSong();
            }
        });
    }


    private Button.OnClickListener toHomeListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
            music.stop();
        }
    };
    private Button.OnClickListener preListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            p--;
            current--;
            if (p < 0){
                p = len - 1;
            }
            photo.setImageResource(imgID[p]);

            if (current < 0){
                current = len - 1;
                if (music != null) {
                    music.reset();
                    music = null;
                }
                playSong(songfile[current]);
            }
            else {
                if (music != null) {
                    music.reset();
                    music = null;
                }
                playSong(songfile[current]);
            }
        }
    };
    private Button.OnClickListener nextListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            p++;
            current++;
            if (p == len){
                p = 0;
            }
            photo.setImageResource(imgID[p]);

            if (current == len){
                current = 0;
                if (music != null) {
                    music.reset();
                    music = null;
                }
                playSong(songfile[current]);
            }
            else {
                if (music != null) {
                    music.reset();
                    music = null;
                }
                playSong(songfile[current]);
            }
        }
    };
    private Button.OnClickListener playListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            music.start();
        }
    };
    private Button.OnClickListener pauseListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            music.pause();
        }
    };
}
