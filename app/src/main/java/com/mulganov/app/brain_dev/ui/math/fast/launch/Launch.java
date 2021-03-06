package com.mulganov.app.brain_dev.ui.math.fast.launch;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mulganov.app.brain_dev.R;

public class Launch extends Fragment {

    private LaunchPresent present;

    private Launch() {
    }

    public static Launch newInstance() {
        Launch fragment = new Launch();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_math_fast_launch, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        present = new LaunchPresent(this);
    }

}
