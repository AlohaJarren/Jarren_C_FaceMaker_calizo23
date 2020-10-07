/**
 * MainActivity.java will be utilized to create all class listeners
 * and particularly will launch the face creation application.
 *
 * @author Jarren Calizo
 * @version 06 Oct 2020
 */

package com.example.jarren_c_facemaker_calizo23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //Specifies array that spinner will utilize later
    public static final String[] hairArray = {"The Fro", "The Skater", "The Hip One"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View faceViewResult = (View) findViewById(R.id.surfaceView);
        Controller faceContResult = new Controller(faceViewResult);
        Face faceModelResult = new Face();

        /**
         * External Citation
         * Problem: I wasn't sure how to make and utilize spinners
         *
         * Resource: https://developer.android.com/guide/topics/ui/controls/spinner#java
         * Solution: Read through and based my spinner code off of their examples
         */
        Spinner spinnerH = (Spinner) findViewById(R.id.spinnerHair);

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, hairArray);
        spinnerH.setAdapter(adapter);
        spinnerH.setOnItemSelectedListener(faceContResult);
        spinnerH.setSelection(faceModelResult.hairStyle);

        Button randomizeB = findViewById(R.id.randomizeButton);
        randomizeB.setOnClickListener(faceContResult);
        RadioGroup radioGroup = findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(faceContResult);
        SeekBar seekBarR = findViewById(R.id.rSeekBar);
        seekBarR.setOnSeekBarChangeListener(faceContResult);
        SeekBar seekBarG = findViewById(R.id.gSeekBar);
        seekBarG.setOnSeekBarChangeListener(faceContResult);
        SeekBar seekBarB = findViewById(R.id.blueSeekBar);
        seekBarB.setOnSeekBarChangeListener(faceContResult);

        seekBarR.setProgress(faceModelResult.rValSkin);
        seekBarG.setProgress(faceModelResult.gValSkin);
        seekBarB.setProgress(faceModelResult.bValSkin);
    }

}