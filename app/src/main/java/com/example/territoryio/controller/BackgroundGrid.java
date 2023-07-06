package com.example.territoryio.controller;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BackgroundGrid{
    private static String TAG = "grid";

    public static final int GRID_X = 50;
    public static final int GRID_Y = 50;


    private int grid[][] = new int[GRID_X][GRID_Y];


    // getter
    public int[][] getGrid() {
        return grid;
    }


    // method
    public void setCharacterPosition(int x, int y, int characterId) {
        grid[x][y] = characterId;
    }

    public void move() {
        for (int i=0; i<grid[0].length; i++) {
            for (int j=0; j<grid[1].length; j++) {
                System.out.print(grid[i][j]);

            }
            System.out.println();
        }
        System.out.println();

    }







}
