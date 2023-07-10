package com.example.territoryio.model;

import android.util.Log;

import com.example.territoryio.controller.BackgroundGrid;

import java.util.LinkedList;
import java.util.List;

public class World {
    // 定数
    public static final int WIDTH = 2000;
    public static final int HEIGHT = 2000;
    public static final int GRID_X = 25;
    public static final int GRID_Y = 25;

    // モデル
    Player player;
    BackgroundGrid backgroundGrid;
    List<Tile> tiles;



//    private int grid[][] = new int[GRID_X][GRID_Y];


    public World() {
        // オブジェクトの生成(モデルの取得)
        player = new Player(100, 100, 1);
        backgroundGrid = new BackgroundGrid();
        for (int i=-1; i<=5; i++) {
            for (int j=-1; j<=5; j++) {
                backgroundGrid.setCharacterPosition(player.getGridX()+i,player.getGridY()+j, 1);
            }
        }

        tiles = new LinkedList<Tile>();
        for(int i=0; i<GRID_X; i++) {
            for (int j=0; j<GRID_Y; j++) {
                Tile tile = new Tile(i*80, j*80);
                tiles.add(tile);
            }
        }



        // モデルの接続
        for (Tile tile : tiles) {
            tile.setPlayer(player);
        }

    }

    public void move() {
        // オブジェクトの更新
        player.move();
        backgroundGrid.move();
        tiles.forEach(x -> x.move());

        backgroundGrid.setCharacterPosition(player.getGridX(), player.getGridY(),player.id);
        for(int i=0; i<GRID_X; i++) {
            for(int j=0; j<GRID_Y; j++) {
                if (backgroundGrid.getGrid()[i][j] == 1) {
                    tiles.get(i*GRID_X+j).setState(1);
                }
            }
        }










        }

    //Getter


    public Player getPlayer() { return player; }

    public List<Tile> getTiles() {
        return tiles;
    }
}
