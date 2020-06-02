package com.mulganov.app.brain_dev.ui.math.fast.fragments.losing;

import android.view.View;

public class LosingPresent {

    private Losing losing;

    public LosingPresent(Losing losing) {
        this.losing = losing;

    }

    public void click_reload(View view){
        this.losing.fast.openGameFragment();
    }
}
