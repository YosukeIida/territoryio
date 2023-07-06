package com.example.territoryio.model;

import android.util.Log;

import com.example.territoryio.controller.BackgroundGrid;

import java.util.LinkedList;
import java.util.List;

public class World {
    // 定数
    public static final int WIDTH = 4000;
    public static final int HEIGHT = 4000;


    // モデル
    Player player;
    BackgroundGrid backgroundGrid;



//    private int grid[][] = new int[GRID_X][GRID_Y];


    public World() {
        // オブジェクトの生成(モデルの取得)
        player = new Player(100, 100, 1);
        backgroundGrid = new BackgroundGrid();



        // モデルの接続

    }

    public void move() {
        // オブジェクトの更新
        player.move();
        backgroundGrid.move();

        backgroundGrid.setCharacterPosition(player.getGridX(), player.getGridY(),player.id);

        for (int i=0; i<backgroundGrid.getGrid()[0].length; i++) {
            for (int j=0; j<backgroundGrid.getGrid()[1].length; j++) {
                if (backgroundGrid.getGrid()[i][j] == 1) {
                    // ステート切り替えをする
                    // 0だったらlightblue
                    // 1だったらenemy敵
//                    lines.add(new Line(i*80, j*80));
                }
            }
        }






        // 毎回最後にlineを削除

//        Log.i("grid", "pcx" + player.getGridX());
//        Log.i("grid", "pcy" + player.getGridY());
    }

    //Getter


    public Player getPlayer() {
        return player;
    }


}
