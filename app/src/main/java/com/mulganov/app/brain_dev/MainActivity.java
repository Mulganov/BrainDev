package com.mulganov.app.brain_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mulganov.app.brain_dev.ui.math.fast.launch.Launch;
import com.mulganov.app.brain_dev.ui.toolbar.ToolbarPresent;

public class MainActivity extends AppCompatActivity {

    public View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.main);

        ToolbarPresent.init(findViewById(R.id.include_toolbar), this);

        openMath_Fast();

        content.setOnClickListener(ToolbarPresent.getToolbar()::onClickWindow);
    }

    public void openMath_Fast(){
        Launch launch = Launch.newInstance();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content,  launch)
                .commitNow();

    }

    public void openBack(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.back).setVisibility(View.VISIBLE);
            }
        });
    }

    public void closeBack(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.back).setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    public void hide(){
        content.post(new Runnable() {
            @Override
            public void run() {
                content.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            }
        });
    }
}
