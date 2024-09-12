package com.example.animation2;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        img = findViewById(R.id.img_blink);
        startBtn = findViewById(R.id.start_tween);
        pauseBtn = findViewById(R.id.pause_tween);
        backBtn = findViewById(R.id.back_to_main_third);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        startBtn.setOnClickListener(view -> {
            img.startAnimation(blinkAnimation);
        });

        pauseBtn.setOnClickListener(view -> {
            img.clearAnimation();
        });

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.common_animation, R.anim.common_animation);
        });

        img.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn2));
        startBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn2));
        pauseBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn2));
        backBtn.startAnimation(AnimationUtils.loadAnimation(this, R.anim.for_btn2));
    }
}
