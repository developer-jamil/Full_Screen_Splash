package com.jamillabltd.fullscreensplash;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

public class FullScreenImageView extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 3000; // 3 seconds

    @SuppressLint({"MissingInflatedId", "ObsoleteSdkInt"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image_view);



        // hide title bar and action bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            // hide time, notifications, network, and battery icons
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE;
                getWindow().getDecorView().setSystemUiVisibility(flags);
            }
        }

        //| View.SYSTEM_UI_FLAG_FULLSCREEN

        //hide action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        // Delay the transition to the main activity using a Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(FullScreenImageView.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIMEOUT);


    }
}