package com.example.territoryio.model;

import com.example.territoryio.controller.BackgroundGrid;

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

   // キャラクターの中央座標
    public int getCenterX() { return x + xSize/2; }
    public int getCenterY() { return y + ySize/2; }

    public int getGridX() { return getCenterX()/ 80; }
    public int getGridY() { return getCenterY()/ 80; }


    public void changeDirection(int direction) {
        switch (direction) {
            case 0:
                xSpeed=0;
                ySpeed=3;
                break;
            case 1:
                xSpeed=-3;
                ySpeed=0;
                break;
            case 2:
                xSpeed=0;
                ySpeed=-3;
                break;
            case 3:
                xSpeed=3;
                ySpeed=0;
                break;
        }

    }

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
