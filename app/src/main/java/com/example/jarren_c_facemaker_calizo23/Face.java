/**
 * Face.java will be utilized for face creation and rendering (surface view display)
 *
 * @author Jarren Calizo
 * @version 06 Oct 2020
 */
package com.example.jarren_c_facemaker_calizo23;

import android.graphics.Color;
import java.lang.*;

/**
 * Face class constructor
 */
public class Face {
    //instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    public int hairStyle;

    int rValSkin = red();
    int gValSkin = green();
    int bValSkin = blue();
    int rValEye = red();
    int gValEye = green();
    int bValEye= blue();
    int rValHair = red();
    int gValHair = green();
    int bValHair = blue();
    int valHair = hairPicker();


    /**
     * helper method that randomize integer value for red color
     */
    public int red() {
        int r = (int)(Math.random() * 256);
        return r;
    }
    /**
     * helper method that randomize integer value for green color
     */
    public int green() {
        int g = (int)(Math.random() * 256);
        return g;
    }
    /**
     * helper method that randomize integer value for blue color
     */
    public int blue() {
        int b = (int)(Math.random() * 256);
        return b;
    }
    /**
     * helper method that helps select a random hairstyle in array
     *
     */
    public int hairPicker() {
        int h = (int) (Math.random() * 3);
        return h;
    }

    /**
     * External Citation
     * Problem: I couldn't figure out how to combine 3 ints into a color
     * (not simple as new Color(red, green, blue))
     *
     * Resource: https://stackoverflow.com/questions/42169773/android-convert-argb-color-to-rgb
     * Solution: I used Color.argb w/ alpha 0xFF
     */

    /**
     * Method that sets random color values to face instance variables
     */
    public void randomize () {
        this.skinColor = Color.argb(0xFF, rValSkin, gValSkin, bValSkin);
        this.eyeColor = Color.argb(0xFF, rValEye, gValEye, bValEye);
        this.hairColor = Color.argb(0xFF, rValHair, gValHair, bValHair);
        this.hairStyle = valHair;
    }
    /**
     * Face class constructor
     */
    public Face() {
        this.randomize();

    }

    public int getHairColor() {
        return this.hairColor;
    }
    public int getSkinColor() {
        return this.skinColor;
    }
    public int getEyeColor() {
        return this.eyeColor;
    }
    public int getHairStyle() {
        return this.hairStyle;
    }
    public int setHairStyle(int hairNum) {
        this.hairStyle = hairNum;
        return this.hairStyle;
    }

}
