package com.example.territoryio.model;

import android.graphics.Point;
import android.util.Log;

import com.example.territoryio.controller.BackgroundGrid;
import com.example.territoryio.controller.DownTimer;

import java.util.LinkedList;
import java.util.List;

public class World {
    // 定数
    public static final int WIDTH = 2000;
    public static final int HEIGHT = 2000;
    public static final int GRID_X = 25;
    public static final int GRID_Y = 25;
    public static final int ENEMY_NUM = 2;

    // モデル
    Player player;
    List<Enemy> enemies;
    BackgroundGrid backgroundGrid;
    List<Tile> tiles;
    DownTimer downTimer;
    List<SpeedUp> speedUps;





    public World() {
        // オブジェクトの生成(モデルの取得)
        player = new Player(100, 100, 1);

        enemies = new LinkedList<Enemy>();
        enemies.add(new Enemy(500, 100, 2));
        enemies.add(new Enemy(100, 800, 3));
        speedUps = new LinkedList<SpeedUp>();
        speedUps.add(new SpeedUp((int)(Math.random()*600), (int)(Math.random()*1400)));
        speedUps.add(new SpeedUp((int)(Math.random()*600), (int)(Math.random()*1400)));
        speedUps.add(new SpeedUp((int)(Math.random()*600), (int)(Math.random()*1400)));

        // downTimerのインスタンス生成
        downTimer = new DownTimer(1*10*1000, 10);
        downTimer.start();

        //　オブジェクトの接続
        speedUps.forEach(x->x.setPlayer(player));


        backgroundGrid = new BackgroundGrid();
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                backgroundGrid.setCharacterPosition(player.getGridX()+i,player.getGridY()+j, player.idArea);
                backgroundGrid.setCharacterPosition(enemies.get(0).getGridX()+i, enemies.get(0).getGridY()+j, enemies.get(0).idArea);
                backgroundGrid.setCharacterPosition(enemies.get(1).getGridX()+i, enemies.get(1).getGridY()+j, enemies.get(1).idArea);
//                for (int k=0; k<enemies.size(); k++) {
//                    backgroundGrid.setCharacterPosition(enemies.get(k).getGridX()+i, enemies.get(k).getGridY()+j, enemies.get(k).idArea);
//                }
            }
        }

        tiles = new LinkedList<Tile>();
        for(int i=0; i<GRID_X; i++) {
            for (int j=0; j<GRID_Y; j++) {
                Tile tile = new Tile(i*80, j*80);
                tiles.add(tile);
            }
        }

    }

    public void move() {
        // オブジェクトの更新
        player.move();
        enemies.forEach(x -> x.move());
        downTimer.move();
        speedUps.forEach(x->x.move());



        // playerがエリアの外の時Lineを引く
        if (backgroundGrid.getGrid()[player.getGridX()][player.getGridY()] != player.idArea) {
            backgroundGrid.setCharacterPosition(player.getGridX(), player.getGridY(), player.idLine);
            Point point = new Point(player.getGridX(), player.getGridY());
            if (player.visited_list.size() == 0) {
                player.visited_list.add(point);
            }
            if (!(player.visited_list.get(player.visited_list.size()-1)).equals(point)) {
                player.visited_list.add(point);
            }

            if (player.isInArea()) {
                player.xLineStart = player.getGridX();
                player.yLineStart = player.getGridY();
                player.directionLineStart = player.getDirection();
                player.setInArea(false);
                System.out.println("出ていった");
                System.out.println(player.directionLineStart);
            }
        } else {
            if (!player.isInArea()) {
                System.out.println("戻ってきた！！");
                System.out.println(player.xLineStart);
                System.out.println(player.yLineStart);

                // 出発した方向が上下方向か
                if ( player.directionLineStart == 0 || player.directionLineStart == 2) {
                    if (player.getGridX() > player.xLineStart) {
                        player.xLineStart += 1;
                    } else {
                        player.xLineStart -= 1;
                    }
                } else {
                    if (player.getGridY() > player.yLineStart) {
                        player.yLineStart += 1;
                    } else {
                        player.yLineStart -= 1;
                    }
                }
                for (int i=0; i<GRID_X; i++) {
                    for (int j=0; j<GRID_Y; j++) {
                        if (backgroundGrid.getGrid()[i][j] == player.getIdLine()) {
                            backgroundGrid.setCharacterPosition(i, j, -1);
                        }
                    }
                }
                System.out.println(player.xLineStart);
                System.out.println(player.yLineStart);

                backgroundGrid.fillArea(player, player.xLineStart, player.yLineStart);
                for (int i=0; i<World.GRID_X; i++) {
                    for (int j = 0; j < World.GRID_Y; j++) {
                        System.out.print(backgroundGrid.getGrid()[i][j]);
                    }
                    System.out.println("");
                }
                for (int i=0; i<GRID_X; i++) {
                    for (int j=0; j<GRID_Y; j++) {
                        if (backgroundGrid.getGrid()[i][j] == -1) {
                            backgroundGrid.setCharacterPosition(i, j, player.idArea);
                        }
                    }
                }
                player.visited_list.clear();
            }
            player.setInArea(true);
        }
        for (int k=0; k<enemies.size(); k++) {
            if (backgroundGrid.getGrid()[enemies.get(k).getGridX()][enemies.get(k).getGridY()] != enemies.get(k).idArea) {
                backgroundGrid.setCharacterPosition(enemies.get(k).getGridX(), enemies.get(k).getGridY(), enemies.get(k).idLine);
                Point point = new Point(enemies.get(k).getGridX(), enemies.get(k).getGridY());
                if (enemies.get(k).visited_list.size() == 0) {
                    enemies.get(k).visited_list.add(point);
                }
                if (!(enemies.get(k).visited_list.get(enemies.get(k).visited_list.size()-1)).equals(point)) {
                    enemies.get(k).visited_list.add(point);
                }

                if (enemies.get(k).isInArea()) {
                    enemies.get(k).xLineStart = enemies.get(k).getGridX();
                    enemies.get(k).yLineStart = enemies.get(k).getGridY();
                    enemies.get(k).directionLineStart = enemies.get(k).getDirection();
                    enemies.get(k).setInArea(false);
                    System.out.println("出ていった");
                    System.out.println(enemies.get(k).directionLineStart);
                }
            } else {
                if (!enemies.get(k).isInArea()) {
                    System.out.println("戻ってきた！！");
                    System.out.println(enemies.get(k).xLineStart);
                    System.out.println(enemies.get(k).yLineStart);

                    // 出発した方向が上下方向か
                    if ( enemies.get(k).directionLineStart == 0 || enemies.get(k).directionLineStart == 2) {
                        if (enemies.get(k).getGridX() > enemies.get(k).xLineStart) {
                            enemies.get(k).xLineStart += 1;
                        } else {
                            enemies.get(k).xLineStart -= 1;
                        }
                    } else {
                        if (enemies.get(k).getGridY() > enemies.get(k).yLineStart) {
                            enemies.get(k).yLineStart += 1;
                        } else {
                            enemies.get(k).yLineStart -= 1;
                        }
                    }
                    for (int i=0; i<GRID_X; i++) {
                        for (int j=0; j<GRID_Y; j++) {
                            if (backgroundGrid.getGrid()[i][j] == enemies.get(k).getIdLine()) {
                                backgroundGrid.setCharacterPosition(i, j, -1);
                            }
                        }
                    }
                    System.out.println(enemies.get(k).xLineStart);
                    System.out.println(enemies.get(k).yLineStart);

                    backgroundGrid.fillArea(enemies.get(k), player.xLineStart, player.yLineStart);
                    for (int i=0; i<World.GRID_X; i++) {
                        for (int j = 0; j < World.GRID_Y; j++) {
                            System.out.print(backgroundGrid.getGrid()[i][j]);
                        }
                        System.out.println("");
                    }
                    for (int i=0; i<GRID_X; i++) {
                        for (int j=0; j<GRID_Y; j++) {
                            if (backgroundGrid.getGrid()[i][j] == -1) {
                                backgroundGrid.setCharacterPosition(i, j, player.idArea);
                            }
                        }
                    }
                    player.visited_list.clear();
                }
                player.setInArea(true);
            }
        }

        // tileの色を決める
        for(int i=0; i<GRID_X; i++) {
            for(int j=0; j<GRID_Y; j++) {
                if (backgroundGrid.getGrid()[i][j] == player.idLine) {
                    tiles.get(i*GRID_X+j).setState(player.idLine);
                }
                if (backgroundGrid.getGrid()[i][j] == player.idArea) {
                    tiles.get(i*GRID_X+j).setState(player.idArea);
                }
                if (backgroundGrid.getGrid()[i][j] == enemies.get(0).idLine) {
                    tiles.get(i*GRID_X+j).setState(enemies.get(0).idLine);
                }
                if (backgroundGrid.getGrid()[i][j] == enemies.get(0).idArea) {
                    tiles.get(i * GRID_X + j).setState(enemies.get(0).idArea);
                }
                if (backgroundGrid.getGrid()[i][j] == enemies.get(1).idLine) {
                    tiles.get(i*GRID_X+j).setState(enemies.get(1).idLine);
                }
                if (backgroundGrid.getGrid()[i][j] == enemies.get(1).idArea) {
                    tiles.get(i * GRID_X + j).setState(enemies.get(1).idArea);
                }

            }
        }










        }

    //Getter


    public Player getPlayer() { return player; }

    public List<Enemy> getEnemies() { return enemies; }

    public List<Tile> getTiles() {
        return tiles;
    }

    public DownTimer getDownTimer() {
        return downTimer;
    }

    public List<SpeedUp> getSpeedUps() {
        return speedUps;
    }
}
