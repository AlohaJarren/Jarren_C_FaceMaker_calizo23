/**
 * MainActivity.java will be utilized to create all class listeners
 * and particularly will launch the face creation application.
 *
 * @author Jarren Calizo
 * @version 10 Sep 2020
 */

package com.example.jarren_c_facemaker_calizo23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //Specifies array that spinner will utilize later
    public static final String[] hairArray = {"Buzzcut", "Spiky", "GuileStFighter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * External Citation
     * Problem: I wasn't sure how to make and utilize spinners
     *
     * Resource: https://developer.android.com/guide/topics/ui/controls/spinner#java
     * Solution: Read through and based my spinner code off of their examples
     */
    /**
     * Method that creates the spinner
     */
    public void makeSpinner() {
        Spinner spinnerHair = (Spinner) findViewById(R.id.spinnerHair);

        ArrayAdapter<CharSequence> adapterHair = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_dropdown_item, hairArray);
        spinnerHair.setAdapter(adapterHair);
    }
}