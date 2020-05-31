package com.mulganov.app.brain_dev.ui.math.fast.fragments.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.Fast;
import com.mulganov.app.brain_dev.ui.math.fast.FastPresent;

public class Game extends Fragment {

    private GamePresent present;
    Fast fast;

    private Game(Fast fast) {
        this.fast = fast;
    }

    public static Game newInstance(Fast fast) {
        Game fragment = new Game(fast);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        present = new GamePresent(this);

        getActivity().findViewById(R.id.math_fast_game_plane_button_a).setOnClickListener(present::onClickButton);
        getActivity().findViewById(R.id.math_fast_game_plane_button_b).setOnClickListener(present::onClickButton);
        getActivity().findViewById(R.id.math_fast_game_plane_button_c).setOnClickListener(present::onClickButton);
        getActivity().findViewById(R.id.math_fast_game_plane_button_d).setOnClickListener(present::onClickButton);

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
        return inflater.inflate(R.layout.fragment_math_fast_game_plane, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        present.breakTimer = true;
    }
}
