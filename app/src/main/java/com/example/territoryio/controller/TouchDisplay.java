package com.example.territoryio.controller;

public class TouchDisplay {
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
    public float getSwipeX() { return (upX - downX); }
    public float getSwipeY() { return (upY - downY); }


    // method
    public int getDirection() {
        if (getSwipeY() > getSwipeX()) {
            if (getSwipeY() < 0) {
                return 0;
            } else {
                return 3;
            }
        } else {
            if (getSwipeX() < 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }



}
