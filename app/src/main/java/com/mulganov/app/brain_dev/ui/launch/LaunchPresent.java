package com.mulganov.app.brain_dev.ui.launch;

import android.view.View;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.Fast;

public class LaunchPresent {

    private Launch launch;

    public LaunchPresent(Launch launch) {
        this.launch = launch;

        launch.getView().findViewById(R.id.launch_button_play).setOnClickListener(this::play);
    }

    public void play(View view) {
        launch.getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content, Fast.newInstance())
                .commitNow();
    }
}
