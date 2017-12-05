package com.example.rs.project_result_mob;

import android.content.Intent;
<<<<<<< HEAD
=======
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
>>>>>>> ff934020eea54aff80450f9ee3970c4e04b94f84
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
=======
    private  static int SPLASH_TIME_OUT = 3000;

>>>>>>> ff934020eea54aff80450f9ee3970c4e04b94f84
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);




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
