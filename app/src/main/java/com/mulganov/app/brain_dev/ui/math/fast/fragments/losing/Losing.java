package com.mulganov.app.brain_dev.ui.math.fast.fragments.losing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.Fast;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.GamePresent;

public class Losing extends Fragment {

    private LosingPresent present;
    Fast fast;

    private Losing(Fast fast) {
        this.fast = fast;
    }

    public static Losing newInstance(Fast fast) {
        Losing fragment = new Losing(fast);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        present = new LosingPresent(this);

        getActivity().findViewById(R.id.math_fast_losing_reload).setOnClickListener(present::click_reload);

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
        return inflater.inflate(R.layout.fragment_math_fast_losing, container, false);
    }
}
