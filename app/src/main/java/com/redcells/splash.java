package com.redcells;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.hide();
        ImageView imageView = findViewById(R.id.splash);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.transition);
        imageView.startAnimation(animation);

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this,OTP.class));
                finish();
            }
        },4000);
    }
}