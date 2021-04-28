package com.example.webview3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Pulse;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    private static int timeout = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();




        rogress_bar();


        imageView = findViewById(R.id.img);
        textView = findViewById(R.id.textID);

        Animation animation = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.welcomanim);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);




        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();


            }
        }, timeout);
    }

    private void rogress_bar() {
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new Pulse();
        progressBar.setIndeterminateDrawable(doubleBounce);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();


    }

    }
