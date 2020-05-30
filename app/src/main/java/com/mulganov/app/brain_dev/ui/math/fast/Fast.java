package com.mulganov.app.brain_dev.ui.math.fast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.Game;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.losing.Losing;

public class Fast extends Fragment {

    private FastPresent present;

    private Fast() {

    }

    public static Fast newInstance() {
        Fast fragment = new Fast();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        present = new FastPresent(this);

        openGameFragment();

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_math_fast, container, false);
    }

    public void openGameFragment(){
        Fast fast = this;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.math_fast_fragment_plane, Game.newInstance(fast))
                        .commitNow();
            }
        });
    }

    public void openLosingFragment(){
        Fast fast = this;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.math_fast_fragment_plane, Losing.newInstance(fast))
                        .commitNow();
            }
        });
    }
}
