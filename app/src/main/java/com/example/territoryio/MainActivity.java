package com.example.territoryio;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.territoryio.helpers.BaseActivity;
import com.example.territoryio.model.World;
import com.example.territoryio.views.MainView;


public class MainActivity extends BaseActivity {

    World world;

    MainView mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gravityEnabled = true;
        orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        world = new World();
        mainView = new MainView(this);

    }

    public void update() {
        world.move();
        mainView.draw(world);

    }

    // イベントリスナー
    public boolean onTouchEvent(MotionEvent event) {
        double tapDownX;
        double tapDownY = 0.0;
        double tapUpX = 0.0;
        double tapUpY = 0.0;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                tapDownX = event.getX();
                tapDownY = event.getY();
//                System.out.println("x" +tapDownX);
//                System.out.println("y" +tapDownY);
                break;
            case MotionEvent.ACTION_UP:
                tapUpX = event.getX();
                tapUpY = event.getY();


                break;

        }
        return true;
    }
}
