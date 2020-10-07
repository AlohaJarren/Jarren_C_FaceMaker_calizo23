/**
 * Controller.java will be utilized for user interaction responses
 * and changes model to reflect commands\
 *
 * @author Jarren Calizo
 * @version 06 Oct 2020
 */
package com.example.jarren_c_facemaker_calizo23;

import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class Controller implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{
    private View generatedView;
    private Face newFace;
    public String colorIndicator = "Hair";

    public Controller (View referenceOfFace) {
        generatedView = referenceOfFace;
        newFace = generatedView.getAdjustFace();
    }
    @Override
    public void onClick(android.view.View view) {
        newFace.randomize();
        generatedView.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, android.view.View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
        newFace.hairStyle = adapterView.getSelectedItemPosition();
        generatedView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        int idx = radioGroup.indexOfChild(radioButton);
        RadioButton r = (RadioButton) radioGroup.getChildAt(idx);
        colorIndicator = r.getText().toString();
        generatedView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int colorCheck = seekBar.getId();
        if(colorCheck == R.id.rSeekBar) {
            switch(colorIndicator) {
                case "Hair":
                    newFace.rValHair =  i;
                    break;
                case "Eyes":
                    newFace.rValEye = i;
                    break;
                case "Skin":
                    newFace.rValSkin = i;
                    break;
            }
        }
        if(colorCheck == R.id.gSeekBar) {
            switch(colorIndicator) {
                case "Hair":
                    newFace.gValHair =  i;
                    break;
                case "Eyes":
                    newFace.gValEye = i;
                    break;
                case "Skin":
                    newFace.gValSkin = i;
                    break;
            }
        }
        if(colorCheck == R.id.blueSeekBar) {
            switch(colorIndicator) {
                case "Hair":
                    newFace.bValHair =  i;
                    break;
                case "Eyes":
                    newFace.bValEye = i;
                    break;
                case "Skin":
                    newFace.bValSkin = i;
                    break;
            }
        }
        generatedView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
