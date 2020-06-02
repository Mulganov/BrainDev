package com.mulganov.app.brain_dev.ui.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.math.fast.FastPresent;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.game.Game;
import com.mulganov.app.brain_dev.ui.math.fast.fragments.losing.Losing;

public class Menu extends Fragment {

    private MenuPresent present;

    private Menu() {

    }

    public static Menu newInstance() {
        Menu fragment = new Menu();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        present = new MenuPresent(this);

        getActivity().findViewById(R.id.menu_button_math_fast).setOnClickListener(present::math_fast);

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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

}
