package com.example.animation2;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private ImageView animationIV;
    private Button startBtn;
    private Button stopBtn;
    private Button backBtn;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        animationIV = findViewById(R.id.animImageView);
        startBtn = findViewById(R.id.startBtn);
        stopBtn = findViewById(R.id.stopBtn);
        backBtn = findViewById(R.id.back_to_main);

        animationIV.setBackgroundResource(R.drawable.anima);
        frameAnimation = (AnimationDrawable) animationIV.getBackground();

        animationIV.setImageDrawable(null);

        startBtn.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        stopBtn.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
        });

        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.for_btn1);
        animationIV.startAnimation(slideIn);
        startBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn1));
        stopBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn1));
        backBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn1));
    }
}
