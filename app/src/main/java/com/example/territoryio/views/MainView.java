package com.example.territoryio.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.territoryio.MainActivity;
import com.example.territoryio.R;
import com.example.territoryio.helpers.BaseView;
import com.example.territoryio.model.GameCharacter;
import com.example.territoryio.model.Player;
import com.example.territoryio.model.Tile;
import com.example.territoryio.model.World;


public class MainView extends BaseView {

    public static final int WINDOW_WIDTH=680;
    public static final int WINDOW_HEIGHT=1540;

    MainActivity mainActivity;
    ConstraintLayout constraintLayout;
    Context context;

    // 定数
    final int BLOCK_COUNT = 5;

    // 画像用変数
    Bitmap backGroundImage;
    Bitmap playerImage;
    Bitmap tileLightBlueImage;

    // ビュー用変数
    ImageViewBuilder imageViewBuilder;

    public MainView(Context context) {
        super(context);
        this.context = context;
        this.mainActivity = (MainActivity) context;

        // 画像の読み込み
        backGroundImage = loadImage(R.drawable.background);
        playerImage = loadImage(R.drawable.character_monster_slime_red);
        tileLightBlueImage = loadImage(R.drawable.tile_lightblue);


        // ビューの生成・登録
        constraintLayout = new ConstraintLayout(context);
        baseActivity.setContentView(constraintLayout);
        imageViewBuilder = new ImageViewBuilder(constraintLayout, context);

    }

    public void draw(World world) {
        // スクロール

        Player player = world.getPlayer();

        if (player.getX() < WINDOW_HEIGHT/2) {
            canvasBaseX = 0;
        } else if (player.getX() < World.WIDTH-WINDOW_HEIGHT/2) {
            canvasBaseX = player.getX() - WINDOW_HEIGHT/2;
        } else {
            canvasBaseX = World.WIDTH-WINDOW_HEIGHT;
        }
        if (player.getY() < WINDOW_WIDTH/2) {
            canvasBaseY = 0;
        } else if (player.getY() < World.HEIGHT-WINDOW_WIDTH/2) {
            canvasBaseY = player.getY()-WINDOW_WIDTH/2;
        } else {
            canvasBaseY = World.HEIGHT-WINDOW_WIDTH;
        }

        // ImageViewBuilderリセット
        imageViewBuilder.reset();

        // 表示
        ImageView imageView = imageViewBuilder.getImageView();

        // 背景を表示
        drawImage(0, 0, World.WIDTH, World.HEIGHT, backGroundImage, imageView);

        world.getTiles().forEach(x -> drawTile(x));



        // playerを表示


        drawPlayer(player);

    }

    //======================
    // テキストビュー表示用の関数
    //======================



    //======================
    // キャラクター表示用の関数
    //======================
    private void drawCharacter(GameCharacter c, Bitmap image) {
        if (c.isActive()) {
            ImageView imageView = imageViewBuilder.getImageView();
            int x = c.getX();
            int y = c.getY();
            int xSize = c.getxSize();
            int ySize = c.getySize();
            drawImage(x, y, xSize, ySize, image, imageView);
        }
    }

    private void drawPlayer(Player player) {
//        Bitmap playerImage = playerImage;
        drawCharacter(player, playerImage);

    }

    private void drawTile(Tile tile) {
        ImageView imageView = imageViewBuilder.getImageView();
        int x=tile.getX();
        int y=tile.getY();
        int xSize=tile.getxSize();
        int ySize=tile.getySize();
        int state=tile.getState();
        switch (state) {
            case 0:
//                imageView.setVisibility(GONE);
                break;
            case 1:
                drawImage(x, y, xSize, ySize, tileLightBlueImage, imageView);
                break;
        }
    }
}


