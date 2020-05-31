package com.mulganov.app.brain_dev.ui.math.fast.fragments.game;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.utils.Utils;

public class GamePresent {

    public static int _timer = 60;            // Сколько секунд будет идти игра

    public Game game;
    Timer timer;
    Utils utils;

    public boolean breakTimer = false;

    public GamePresent(Game game) {
        this.game = game;

        timer = new Timer(this);
        timer.startTimer(game.getActivity().findViewById(R.id.math_fast_progressBar));

        utils = new Utils(this);

        utils.reloadLesson();
    }

    public void finishTimer(){
        game.fast.openLosingFragment();
    }

    public void onClickButton(View v){
        Button b = (Button)v;

        float otvet = Float.parseFloat(b.getText() + "");

        if (otvet == utils.lesson.otvet){
            utils.win(b);
        }else{
            utils.lose(utils.getWinButton());
        }
    }
}


class Timer{

    GamePresent present;

    public Timer(GamePresent fastPresent) {
        present = fastPresent;
    }

    public void startTimer(ProgressBar progressBar){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int max = 1000;
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setMax(max);
                    }
                });

                for (int i = max; i > -1; i--){
                    int finalI = i;
                    progressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(finalI);
                        }
                    });

                    if (present.breakTimer)
                        return;

                    try {
                        Thread.sleep(present._timer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                present.finishTimer();
            }
        }).start();
    }

    public void stopTimer(){

    }
}

