package com.mulganov.app.brain_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.mulganov.app.brain_dev.ui.launch.Launch;
import com.mulganov.app.brain_dev.ui.toolbar.ToolbarPresent;

public class MainActivity extends AppCompatActivity {

    private View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.main);

        Launch launch = Launch.newInstance();

        ToolbarPresent.init(findViewById(R.id.include_toolbar));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_content,  launch)
                .commitNow();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hide();
    }

    public void hide(){
        content.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
