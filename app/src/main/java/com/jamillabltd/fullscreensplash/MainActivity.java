package com.jamillabltd.fullscreensplash;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button fullScreenImage = findViewById(R.id.fullScreenImageId);
        fullScreenImage.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FullScreenImageView.class)));

    }
}