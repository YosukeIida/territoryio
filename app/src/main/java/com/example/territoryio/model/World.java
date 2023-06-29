package com.example.territoryio.model;

public class World {
    // 定数
    public static final int WIDTH = 2000;
    public static final int HEIGHT = 2000;

    // オブジェクト用変数
    private Player player;


    public World() {
        // オブジェクトの生成
        player = new Player(100, 100);

    }

    public void move() {
        // オブジェクトの更新
        player.move();

    }

    //Getter


    public Player getPlayer() {
        return player;
    }
}
