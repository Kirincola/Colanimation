package com.soragoto.cola.animation;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

import com.soragoto.cola.animation.databinding.ActivityMainBinding;

import java.text.ParseException;

import info.nukoneko.android.lib.nkanimation.NKAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_main);

        final AnimeController controller = new AnimeController();
        binding.animationView.addController( controller );

        controller.setRadius( 200 );
        binding.textRadius.setText("200");
        binding.seekRadius.setProgress( 40 );

        controller.setSpeed( 0.05f );
        binding.textSpeed.setText("0.05");
        binding.seekSpeed.setProgress( 50 );

        binding.seekRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                controller.setRadius( progress * 5 );
                binding.textRadius.setText( String.valueOf( progress * 5 ) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.seekSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress *= 2;
                controller.setSpeed( (float) ( progress / 1000.0) );
                binding.textSpeed.setText( String.valueOf( progress / 1000.0) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
