package com.example.territoryio.controller;

import android.util.Log;

public class BackgroundGrid{
    private static String TAG = "grid";

    public static final int GRID_X = 50;
    public static final int GRID_Y = 50;

    private int grid[][] = new int[GRID_X][GRID_Y];

    public void move() {
        Log.i("grid", "grid" + grid);
    }



}
