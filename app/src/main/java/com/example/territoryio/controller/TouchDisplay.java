package com.example.territoryio.controller;

import android.util.Log;

public class TouchDisplay {
    private static String TAG = "myapp";
    private float downX;
    private float downY;
    private float upX;
    private float upY;

    // Setter
    public void setDownX(float downX) {
        this.downX = downX;
    }

    public void setDownY(float downY) {
        this.downY = downY;
    }

    public void setUpX(float upX) {
        this.upX = upX;
    }

    public void setUpY(float upY) {
        this.upY = upY;
    }


    // Getter
    public float getSwipeX() {
        Log.i("myapp", "x" + (upX - downX));
        return (upX - downX); }
    public float getSwipeY() {
        Log.i("myapp", "y" + (upY - downY));
        return (upY - downY); }


    // method
    public int getDirection() {
        if ( Math.abs(getSwipeY()) > Math.abs(getSwipeX())) {
            if (getSwipeY() < 0) {
                return 0;
            } else {
                return 2;
            }
        } else {
            if (getSwipeX() < 0) {
                return 1;
            } else {
                return 3;
            }
        }
    }



}
