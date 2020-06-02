package com.mulganov.app.brain_dev.ui.menu;

import android.view.View;

import com.mulganov.app.brain_dev.MainActivity;

public class MenuPresent {
    private Menu menu;

    public MenuPresent(Menu menu) {
        this.menu = menu;
    }


    public void math_fast(View view) {
        ((MainActivity)menu.getActivity()).openMath_Fast();
    }
}
