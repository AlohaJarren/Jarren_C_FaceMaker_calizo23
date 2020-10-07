/**
 * View.java will be utilized for holding information
 * about the state of the application (surface view display)
 *
 * @author Jarren Calizo
 * @version 06 Oct 2020
 */
package com.example.jarren_c_facemaker_calizo23;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class View extends SurfaceView {
    //instance variables
    private Face adjustFace = new Face();

    //create paints
    private Paint hairColor = new Paint();
    private Paint skinColor = new Paint();
    private Paint eyeWhiteColor = new Paint();
    private Paint outerEyeColor = new Paint();
    private Paint innerEyeColor = new Paint();
    private Paint mouthColor = new Paint();
    private Paint tongueColor = new Paint();
    private Paint redIndicator = new Paint();
    private Paint greenIndicator = new Paint();
    private  Paint blueIndicator = new Paint();

    /**
     * Method to allow predefined values to create paints
     */
    public void makeColors() {
        hairColor.setColor(adjustFace.getHairColor());
        hairColor.setStyle(Paint.Style.FILL);
        skinColor.setColor(adjustFace.getSkinColor());
        skinColor.setStyle(Paint.Style.FILL);
        eyeWhiteColor.setColor(Color.WHITE);
        eyeWhiteColor.setStyle(Paint.Style.FILL);
        outerEyeColor.setColor(adjustFace.getEyeColor());
        outerEyeColor.setStyle(Paint.Style.FILL);
        innerEyeColor.setColor(Color.BLACK);
        innerEyeColor.setStyle(Paint.Style.FILL);
        mouthColor.setColor(Color.BLACK);
        mouthColor.setStyle(Paint.Style.FILL);
        tongueColor.setColor(Color.MAGENTA);
        tongueColor.setStyle(Paint.Style.FILL);

    }

    public Face getAdjustFace() {
        return this.adjustFace;
    }

    public View(Context context, AttributeSet attr) {
        super(context, attr);
        this.setWillNotDraw(false);
        setBackgroundColor(0xF9E559);
        this.makeColors();
        redIndicator.setColor(Color.RED);
        redIndicator.setTextSize(30f);
        greenIndicator.setColor(Color.GREEN);
        greenIndicator.setTextSize(30f);
        blueIndicator.setColor(Color.BLUE);
        blueIndicator.setTextSize(30f);
    }
    /**
     * method that will create the face on the application surface view
     *
     * @param canvas where method will be drawn on
     */
    public void onDraw(Canvas canvas) {
        hairColor.setColor(adjustFace.getHairColor());
        skinColor.setColor(adjustFace.getSkinColor());
        outerEyeColor.setColor(adjustFace.getEyeColor());
        drawFace(canvas);
        drawHair(canvas);
        drawEyes(canvas, 500, 700, 350, 50);
        drawMouth(canvas);
    }

    @SuppressLint("NewApi")
    public void drawFace(Canvas canvas) {
        canvas.drawOval(400,150,800,650, skinColor);
    }

    /**
     * method that draws hair
     *
     * @param canvas: area that hair will be drawn on
     */
    public void drawHair(Canvas canvas) {
        switch(adjustFace.getHairStyle()) {
            case 0:
                drawFro(canvas);
                break;
            case 1:
                drawSkater(canvas);
                break;
            case 2:
                drawHipOne(canvas);
                break;
        }
    }

    @SuppressLint("NewApi")
    public void drawFro(Canvas canvas) {
        canvas.drawOval(300, 0, 900, 500, hairColor);
    }
    public void drawSkater(Canvas canvas) {
        canvas.drawRect(430, 140, 770, 500, hairColor);
    }
    @SuppressLint("NewApi")
    public void drawHipOne(Canvas canvas) {
        canvas.drawOval(390, 120, 810, 500, hairColor);
        canvas.drawRect(390, 300, 810, 700, hairColor);
    }

    /**
     * method that draws eyes
     *
     * @param canvas: area that eyes will be drawn on
     */
    public void drawEyes(Canvas canvas, int inC, int outC, int width1, int width2) {
        //draws white eye circles
        canvas.drawCircle(inC, width1, width2, eyeWhiteColor);
        canvas.drawCircle(outC, width1, width2, eyeWhiteColor);

        //draws unique eye color based on rgb
        canvas.drawCircle(inC, width1, width2* 3/5, outerEyeColor);
        canvas.drawCircle(outC, width1, width2*3/5, outerEyeColor);

        //draws black inner eyes
        canvas.drawCircle(inC, width1, width2*1/5, innerEyeColor);
        canvas.drawCircle(outC, width1, width2*1/5, innerEyeColor);
    }

    /**
     * method that draws a mouth
     *
     * @param canvas: area that mouth will be drawn on
     */
    @SuppressLint("NewApi")
    public void drawMouth(Canvas canvas) {
        //draws the mouth then the tongue
        canvas.drawRect(570, 560, 630, 580, mouthColor);
        canvas.drawOval(570, 570, 630, 590, tongueColor);
    }
}
