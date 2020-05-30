package com.mulganov.app.brain_dev.ui.math.fast.fragments.losing;

import android.view.View;

import com.mulganov.app.brain_dev.ui.math.fast.Fast;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.Game;

public class LosingPresent {

    private Losing losing;

    public LosingPresent(Losing losing) {
        this.losing = losing;

    }

    public void click_reload(View view){
        losing.fast.openGameFragment();
    }
}
