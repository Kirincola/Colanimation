package com.soragoto.cola.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.ParseException;

import info.nukoneko.android.lib.nkanimation.NKAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText text = (EditText) findViewById(R.id.text);
        NKAnimationView anime = (NKAnimationView) findViewById(R.id.animationview);
        final AnimeController controller = new AnimeController();
        anime.addController( controller );
        controller.setValue(50);

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    controller.setValue( Integer.parseInt( text.getText().toString() ) );
                } catch( android.net.ParseException | NumberFormatException ignore ) {

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
