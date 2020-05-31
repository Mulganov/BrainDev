package com.mulganov.app.brain_dev.ui.math.fast.fragments.game.utils;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.GamePresent;


public class Utils {
    private GamePresent present;

    private int level;
    private int otvets;

    public Lesson lesson;

    public Utils(GamePresent present){
        this.present = present;
    }

    public void reloadLesson() {

        present.game.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView text_lesson = present.game.getActivity().findViewById(R.id.math_fast_text_question);
                TextView text_otvet = present.game.getActivity().findViewById(R.id.math_fast_text_otvets);
                TextView text_level = present.game.getActivity().findViewById(R.id.math_fast_text_level);

                text_level.setText("Ваш уровень: " + level);
                text_otvet.setText("Количество ответов: " + otvets);

                int pm = level / 5;
                int md = level / 10;

                Lesson.level_plus_minus = 10 + pm;
                Lesson.level_mul_div = 3 + md;

                lesson = new Lesson();

                text_lesson.setText(lesson.a + "" + lesson.znak + "" +  lesson.b + "=?");

                Button b_a = present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_a);
                Button b_b = present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_b);
                Button b_c = present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_c);
                Button b_d = present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_d);

                b_a.setText(lesson.otvets.a + "");

                b_b.setText(lesson.otvets.b + "");

                b_c.setText(lesson.otvets.c + "");

                b_d.setText(lesson.otvets.d + "");
            }
        });
    }

    public void win(Button b) {
        level++;
        otvets++;

        finishLesson(b);
    }

    public void lose(Button b) {
        level--;
        if (level < 0)
            level = 0;

        finishLesson(b);
    }

    private void finishLesson(Button b){
        allButtonRed();
        b.setBackgroundColor(Color.GREEN);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                allButtonStandartBack();

                reloadLesson();
            }
        }).start();

    }

    private void allButtonStandartBack(){
        present.game.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_a).setBackgroundResource(R.drawable.math_fast_game_plane_button);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_b).setBackgroundResource(R.drawable.math_fast_game_plane_button);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_c).setBackgroundResource(R.drawable.math_fast_game_plane_button);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_d).setBackgroundResource(R.drawable.math_fast_game_plane_button);
            }
        });
    }

    private void allButtonRed(){
        present.game.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_a).setBackgroundColor(Color.RED);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_b).setBackgroundColor(Color.RED);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_c).setBackgroundColor(Color.RED);
                present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_d).setBackgroundColor(Color.RED);
            }
        });
    }

    public Button getWinButton() {
        if ( Float.parseFloat(((Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_a)).getText() + "") == lesson.otvet )
            return (Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_a);

        if ( Float.parseFloat(((Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_b)).getText() + "") == lesson.otvet )
            return (Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_b);

        if ( Float.parseFloat(((Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_c)).getText() + "") == lesson.otvet )
            return (Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_c);

        else
//        if ( Float.parseFloat(((Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_d)).getText() + "") == lesson.otvet )
            return (Button)present.game.getActivity().findViewById(R.id.math_fast_game_plane_button_d);

    }
}
