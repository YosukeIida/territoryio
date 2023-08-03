package com.example.territoryio.model;

public class SpeedUp extends GameCharacter{
    private Player player;
    private int state;
    private int count;
    private boolean disappearFlag;

    public SpeedUp(int x, int y) {
        this.x=x;
        this.y=y;
        xSize=80;
        ySize=80;
    }

    public void setPlayer(Player player) {this.player = player;}


//    public int getState() {
//        return state;
//    }
    public boolean isDisapearFlag() {
        return disappearFlag;
    }

    public void move() {
        if(disappearFlag==false && overlap(player)){
            player.upSpeed();
            disappearFlag=true;
        }
        if(disappearFlag==true){
            state=0;
        }else {
            count++;
            if (count > 200) {
                player.downSpeed();
                count = 0;
            }
        }
    }


}
