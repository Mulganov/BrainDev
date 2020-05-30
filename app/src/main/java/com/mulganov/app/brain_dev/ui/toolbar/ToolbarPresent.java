package com.mulganov.app.brain_dev.ui.toolbar;

import android.view.View;

import com.mulganov.app.brain_dev.R;

public class ToolbarPresent {

    public static ToolbarPresent toolbar;

    public static ToolbarPresent getToolbar(View v){
        return toolbar;
    }

    public static ToolbarPresent init(View v){
        ToolbarPresent toolbar = new ToolbarPresent(v);
        ToolbarPresent.toolbar = toolbar;

        return toolbar;
    }


    private ToolbarPresent(View v){
        v.findViewById(R.id.toolbar_setting).setOnClickListener(this::onClickSetting);
        v.findViewById(R.id.toolbar_menu).setOnClickListener(this::onClickMenu);
    }

    private void onClickMenu(View view) {
    }

    public void onClickSetting(View v){
    }

}
