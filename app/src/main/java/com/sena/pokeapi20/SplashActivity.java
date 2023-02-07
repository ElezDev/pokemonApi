package com.sena.pokeapi20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private View imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView textView = findViewById(R.id.textSpashScreen);
        textView.animate().translationX(1000).setDuration(1000).setStartDelay(2500);


        imgv =findViewById(R.id.imageViewlll);
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.animacion);
        imgv.setAnimation(animation);


        Thread splashScreenStarter = new Thread() {
            public void run() {
                try {
                    int delay = 0;
                    while (delay < 2400) {
                        sleep(190);
                        delay = delay + 100;
                    }

                    startActivity(new

                            Intent(SplashActivity.this, MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        splashScreenStarter.start();
    }
}


