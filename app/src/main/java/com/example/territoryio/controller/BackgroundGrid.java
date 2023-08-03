package com.example.territoryio.controller;

import android.util.Log;

import com.example.territoryio.model.GameCharacter;
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
    public void fillArea(GameCharacter gameCharacter, int x, int y) {

        if (grid[x][y] == -1) {
            return;
        }
        grid[x][y] = -1;
//      領域から外に出たグリッドと入ってきたグリッドが隣り合わせの時，fillAreaができない
//          -> playerが通った座標を記録するvisitedを作った
//          -> visitedの座標をもとに塗りつぶしをするようにfillAreaを変更する必要がある
//          -> 出たグリッドと入ってきたグリッドが隣り合わせの時，最初から最後まで探索する

        if (!(grid[x+1][y] == -1 || grid[x+1][y] == gameCharacter.getIdArea())) {
            System.out.println("b");
            fillArea(gameCharacter, x+1, y);
        }
        if (!(grid[x][y+1] == -1 || grid[x][y+1] == gameCharacter.getIdArea())) {
            fillArea(gameCharacter, x, y+1);
        }
        if (!(grid[x-1][y] == -1 || grid[x-1][y] == gameCharacter.getIdArea())) {
            fillArea(gameCharacter, x-1, y);
        }
        if (!(grid[x][y-1] == -1 || grid[x][y-1] == gameCharacter.getIdArea())) {
            fillArea(gameCharacter, x, y-1);
        }
    }

}
