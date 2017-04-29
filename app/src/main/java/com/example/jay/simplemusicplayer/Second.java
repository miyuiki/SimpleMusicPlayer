package com.example.jay.simplemusicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by jay on 2017/4/28.
 */

public class Second extends AppCompatActivity{

    int[] imgID = {R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img04, R.drawable.img05};
    private Button pre, next;
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

        toHome.setOnClickListener(toHomeListener);
        pre.setOnClickListener(preListener);
        next.setOnClickListener(nextListener);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String num = bundle.getString("NUMBER");
        photo.setImageResource(imgID[Integer.parseInt(num)-1]);
    }
    private Button.OnClickListener toHomeListener = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            finish();
        }
    };
    private Button.OnClickListener preListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            p--;
            if (p < 0){
                p = len - 1;
            }
            photo.setImageResource(imgID[p]);
        }
    };
    private Button.OnClickListener nextListener = new Button.OnClickListener(){
        @Override
        public void onClick(View view) {
            p++;
            if (p == len){
                p = 0;
            }
            photo.setImageResource(imgID[p]);
        }
    };
}
