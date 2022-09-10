package com.example.bruhbutton;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruhbutton.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends Activity implements View.OnClickListener {
    //  private TextView mTextView;
    private ActivityMainBinding binding;
    private SoundPool soundPool;
    private int bruhSound;

    private final AnimationSet expandAndShrink = new AnimationSet(true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AudioAttributes audioAttributes = new AudioAttributes
                .Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool
                .Builder()
                .setMaxStreams(8)
                .setAudioAttributes(audioAttributes)
                .build();

        bruhSound = soundPool.load(this, R.raw.bruh, 1);

        ScaleAnimation shrink = new ScaleAnimation(
                1f, 0.97f,
                1f, 0.97f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        shrink.setDuration(10);

        ScaleAnimation expand = new ScaleAnimation(
                0.97f, 1.0f,
                0.97f, 1.0f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        expand.setStartOffset(50);
        expand.setDuration(10);

        expandAndShrink.addAnimation(shrink);
        expandAndShrink.addAnimation(expand);
        expandAndShrink.setInterpolator(new AccelerateInterpolator(1.0f));

        Button bruhButton = findViewById(R.id.bruhButton);
        bruhButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        soundPool.play(bruhSound, 1, 1, 0, 0, 1);
        v.startAnimation(expandAndShrink);
    }
}