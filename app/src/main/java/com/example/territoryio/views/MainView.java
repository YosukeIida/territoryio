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
import com.example.territoryio.model.World;


public class MainView extends BaseView {

    MainActivity mainActivity;
    ConstraintLayout constraintLayout;
    Context context;

    // 定数
    final int BLOCK_COUNT = 5;

    // 画像用変数
    Bitmap backGroundImage;

    // ビュー用変数
    ImageViewBuilder imageViewBuilder;

    public MainView(Context context) {
        super(context);
        this.context = context;
        this.mainActivity = (MainActivity) context;

        // 画像の読み込み
        backGroundImage = loadImage(R.drawable.background);


        // ビューの生成・登録
        constraintLayout = new ConstraintLayout(context);
        baseActivity.setContentView(constraintLayout);
        imageViewBuilder = new ImageViewBuilder(constraintLayout, context);

    }

    public void draw(World world) {
        // スクロール


        // ImageViewBuilderリセット
        imageViewBuilder.reset();

        // 表示
        ImageView imageView = imageViewBuilder.getImageView();

        // 背景を表示
        drawImage(0, 0, World.WIDTH, World.HEIGHT, backGroundImage, imageView);

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
}


