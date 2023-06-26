package com.example.territoryio.model;

public class Player extends GameCharacter {

    public Player (int x, int y) {
        this.x=x;
        this.y=y;
        this.xSize=80;
        this.ySize=80;
        this.xSpeed=0;
        this.ySpeed=3;
    }
    // キャラクターの進行方向 0:上, 1:左, 2:下, 3:右
    private int direction = 0;



    public void move() {
        x += xSpeed;
        y += ySpeed;

        // playerが画面からはみ出さないようにする
        if (x < 0) {
            x=0;
        } else if (x > World.WIDTH - xSize) {
            x = World.WIDTH - xSize;
        }
        if (y < 0) {
            y=0;
        } else if (y > World.HEIGHT - ySize) {
            y = World.HEIGHT - ySize;
        }


    }

}
