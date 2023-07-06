package com.example.territoryio.model;

import com.example.territoryio.controller.BackgroundGrid;

public class Tile extends GameCharacter {

    Player player;
    public Tile(int x, int y) {
        this.x=x;
        this.y=y;
        this.xSize=80;
        this.ySize=80;
    }

    //0:none, 1:player_line, 2:player_area, 3:enemy1_line:, 4:enemy2_area....
    private int state = 0;

    // getter
    public int getState() {
        return state;
    }



    // setter
    public void setState(int state) {
        this.state = state;
    }
    public void setPlayer(Player player) { this.player = player; }


    public void move() {
        if ( overlap())


    }



}
