package com.mulganov.app.brain_dev.ui.toolbar.menu;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.mulganov.app.brain_dev.R;
import com.mulganov.app.brain_dev.ui.toolbar.ToolbarPresent;

public class MenuPresent {
    private ToolbarPresent present;

    private PopupWindow popupWindow;

    public MenuPresent(ToolbarPresent toolbarPresent){
        present = toolbarPresent;
    }

    public void onClickMenu(View view) {
        openMainMenu();
    }

    private void openMainMenu(){
        LayoutInflater inflater = (LayoutInflater)
                present.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.fragment_menu, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = false;

        popupView.findViewById(R.id.menu_button_math_fast).setOnClickListener(this::openMath_Fast);

        popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(present.activity.findViewById(R.id.main), Gravity.CENTER,0, 0);

        present.activity.openBack();

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                present.activity.closeBack();
            }
        });
    }

    public void closePopup(){
        if (popupWindow != null)
                popupWindow.dismiss();
    }

    private void openMath_Fast(View v){
        present.activity.openMath_Fast();
        present.activity.closeBack();
        popupWindow.dismiss();
    }
}
