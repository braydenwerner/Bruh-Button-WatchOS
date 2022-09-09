package com.example.bruhbutton;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bruhbutton.databinding.ActivityMainBinding;

public class MainActivity extends Activity implements View.OnClickListener {

    //  private TextView mTextView;
    private ActivityMainBinding binding;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mediaPlayer = MediaPlayer.create(this, R.raw.bruh);

        Button bruhButton = findViewById(R.id.bruhButton);
        bruhButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        mediaPlayer.start();
    }
}