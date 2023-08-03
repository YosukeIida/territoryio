package com.example.territoryio.model;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends GameCharacter{

    public Enemy (int x, int y, int id) {
        this.x=x;
        this.y=y;
        this.xSize=80;
        this.ySize=80;
        this.xSpeed=0;
        this.ySpeed=8;
        this.idLine=id*2 -1;
        this.idArea=id*2;
    }
    private int cnt = 0;
    private int direction = 0;
    private boolean inArea = true;

    public int xLineStart = 0;
    public int yLineStart = 0;
    public int directionLineStart = 0;
    public List<Point> visited_list = new ArrayList<Point>();

//     キャラクターの中央座標
    public int getCenterX() { return x + xSize/2; }
    public int getCenterY() { return y + ySize/2; }

    public int getGridX() { return getCenterX()/ 80; }
    public int getGridY() { return getCenterY()/ 80; }

    public boolean isInArea() { return inArea; }

    public int getDirection() { return direction; }
    public int getIdLine() { return idLine; }
    public int getIdArea() { return idArea; }

//     setter
    public void setInArea(boolean inArea) { this.inArea = inArea; }

    public void changeDirection(int direction) {
        this.direction = direction;
        switch (direction) {
            case 0:
                xSpeed=0;
                ySpeed=8;
                break;
            case 1:
                xSpeed=-8;
                ySpeed=0;
                break;
            case 2:
                xSpeed=0;
                ySpeed=-8;
                break;
            case 3:
                xSpeed=8;
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

//        cnt++;
//        if (direction==0 && cnt %100 == 0) {
//            changeDirection(3);
//        }
//        else if (direction==3 && cnt %100 == 0) {
//            changeDirection(2);
//        }
//        else if (direction==2 && cnt %100 == 0) {
//            changeDirection(1);
//        }
//        else if (direction==1 && cnt %100 == 0) {
//            if (cnt %800 == 0) {
//                changeDirection(3);
//            }
//            changeDirection(0);
//        }




    }
}
