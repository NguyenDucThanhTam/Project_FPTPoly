package com.example.rs.project_result_mob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
//        blurBackground();
    }

    private void blurBackground() {
        RelativeLayout  layout = (RelativeLayout)findViewById(R.id.layout_first);
        layout.getBackground().setAlpha(25);
    }
}
