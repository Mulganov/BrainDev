package com.mulganov.app.brain_dev.ui.toolbar;

import android.view.View;

import com.mulganov.app.brain_dev.MainActivity;
import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.toolbar.menu.MenuPresent;

public class ToolbarPresent {

    public static ToolbarPresent toolbar;

    public static ToolbarPresent getToolbar(){
        return toolbar;
    }

    public static ToolbarPresent init(View v, MainActivity activity){
        ToolbarPresent toolbar = new ToolbarPresent(v);
        ToolbarPresent.toolbar = toolbar;
        toolbar.activity = activity;
        return toolbar;
    }

    public MainActivity activity;
    private MenuPresent menu;

    private ToolbarPresent(View v){
        menu = new MenuPresent(this);

        v.findViewById(R.id.toolbar_setting).setOnClickListener(this::onClickSetting);
        v.findViewById(R.id.toolbar_menu).setOnClickListener(menu::onClickMenu);
    }

    public void onClickSetting(View v){
    }

    public void onClickWindow(View view) {
        menu.closePopup();
    }
}
