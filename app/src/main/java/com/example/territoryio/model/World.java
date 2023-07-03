package com.example.territoryio.model;

import android.util.Log;

import com.example.territoryio.controller.BackgroundGrid;

public class World {
    // 定数
    public static final int WIDTH = 4000;
    public static final int HEIGHT = 4000;
//    public static final int GRID_X = 50;
//    public static final int GRID_Y = 50;


    private static String TAG = "grid";


    // オブジェクト用変数
    private Player player;
    private BackgroundGrid backgroundGrid;

//    private int grid[][] = new int[GRID_X][GRID_Y];


    public World() {
        // オブジェクトの生成
        player = new Player(100, 100);
        backgroundGrid = new BackgroundGrid();

    }

    public void move() {
        // オブジェクトの更新
        player.move();
//        backgroundGrid.move();






        Log.i("grid", "pcx" + player.getGridX());
        Log.i("grid", "pcy" + player.getGridY());
    }

    //Getter


    public Player getPlayer() {
        return player;
    }
}
