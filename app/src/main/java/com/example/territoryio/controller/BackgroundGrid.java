package com.example.territoryio.controller;

import android.util.Log;

import com.example.territoryio.model.World;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BackgroundGrid{

    private int grid[][] = new int[World.GRID_X][World.GRID_Y];


    // getter
    public int[][] getGrid() {
        return grid;
    }


    // method
    public void setCharacterPosition(int x, int y, int characterId) {
        grid[x][y] = characterId;
    }

    public void move() {
        for (int i=0; i<25; i++) {
            for (int j=0; j<25; j++) {
                System.out.print(grid[i][j]);

            }
            System.out.println();
        }
        System.out.println("aaa");

    }







}
