package com.example.territoryio.controller;

import android.util.Log;

import com.example.territoryio.model.Player;
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
    public void setCharacterPosition(int x, int y, int idLine) { grid[x][y] = idLine; }

//    public void fillArea(int xStart, int yStart, int xEnd, int yEnd, int direction, int id) {
    public void fillArea(Player player, int x, int y) {

        grid[x][y] = -1;

        for (int i=0; i<World.GRID_X; i++) {
            for (int j = 0; j < World.GRID_Y; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
        System.out.println("aaa");

        if (!(grid[x+1][y] == -1 || grid[x+1][y] == player.getIdArea())) {
            System.out.println("b");
            fillArea(player, x+1, y);
        }
        if (!(grid[x][y+1] == -1 || grid[x][y+1] == player.getIdArea())) {
            fillArea(player, x, y+1);
        }
        if (!(grid[x-1][y] == -1 || grid[x-1][y] == player.getIdArea())) {
            fillArea(player, x-1, y);
        }
        if (!(grid[x][y-1] == -1 || grid[x][y-1] == player.getIdArea())) {
            fillArea(player, x, y-1);
        }
    }

}
