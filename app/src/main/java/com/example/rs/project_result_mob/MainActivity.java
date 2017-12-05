package com.example.rs.project_result_mob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
//        blurBackground();
        //ket noi vs firebase
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");

            myRef.setValue("");
        }


    private void blurBackground() {
        RelativeLayout  layout = (RelativeLayout)findViewById(R.id.layout_first);
        layout.getBackground().setAlpha(25);
    }
}
