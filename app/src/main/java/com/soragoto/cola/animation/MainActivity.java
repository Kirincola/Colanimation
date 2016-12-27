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
        controller.setValue( 200 );
        binding.seek.setProgress( 40 );
        binding.text.setText("200");
        
        binding.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                controller.setValue( progress * 5 );
                binding.text.setText( String.valueOf( progress * 5 ) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
////        binding.seek.addTextChangedListener(new TextWatcher() {
////            @Override
////            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
////
////            }
////
////            @Override
////            public void onTextChanged(CharSequence s, int start, int before, int count) {
////                try {
////                    controller.setValue( Integer.parseInt( binding.text.getText().toString() ) );
////                } catch( android.net.ParseException | NumberFormatException ignore ) {
////
////                }
////
////            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }
}
