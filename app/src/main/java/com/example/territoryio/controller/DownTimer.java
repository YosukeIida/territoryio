package com.example.territoryio.controller;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DownTimer extends CountDownTimer {
    public DownTimer(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    private String timerText;
    private boolean finished = false;

    private SimpleDateFormat dateFormat =
            new SimpleDateFormat("mm:ss.SSS", Locale.JAPAN);


    @Override
    public void onFinish() {
        timerText = (dateFormat.format(0));
        }

    // インターバルで呼ばれる
    @Override
    public void onTick(long millisUntilFinished) {
        // 残り時間を分、秒、ミリ秒に分割
        long mm = millisUntilFinished / 1000 / 60;
        long ss = millisUntilFinished / 1000 % 60;
        long ms = millisUntilFinished - ss * 1000 - mm * 1000 * 60;
        timerText =  String.format("%1$02d:%2$02d.%3$03d", mm, ss, ms);

        }



    // getter
    public boolean isFinished() {
        return finished;
    }

    public String getTimerText() {
        return timerText;
    }

    public void move() {
        if (timerText.equals(dateFormat.format(0))) {
            finished = true;
        }
    }

}
