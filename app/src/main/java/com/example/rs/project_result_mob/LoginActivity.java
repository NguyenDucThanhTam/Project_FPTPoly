package com.example.rs.project_result_mob;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.Toast;

import jp.wasabeef.blurry.Blurry;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView br, btnImageExit;
    DigitalClock digitalClock;
    Button btnLoginGg, btnLoginFacebook, btnLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setBlurBR();
        initMapped();
        initEvent();
    }

    private void initEvent() {
        btnImageExit.setOnClickListener(this);
        btnLoginUser.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
        btnLoginGg.setOnClickListener(this);
    }

    private void initMapped() {
        btnImageExit = (ImageView) findViewById(R.id.btnImageExit);
        btnLoginGg = (Button) findViewById(R.id.btnLoginGoogle_LoginActivity);
        btnLoginFacebook = (Button) findViewById(R.id.btnLoginFaceBook_LoginActivity);
        btnLoginUser = (Button) findViewById(R.id.btnLoginUser_LoginActivity);
    }

    private void setBlurBR() {
        br = (ImageView) findViewById(R.id.background_main);
        Bitmap resultBmp = BlurBuilder.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.br_login));
        br.setImageBitmap(resultBmp);
        digitalClock = (DigitalClock) findViewById(R.id.digital_LoginActivity);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnImageExit:
                try {
                    // Close Activity
                    Toast.makeText(this, "!!! Thank for used !!!", Toast.LENGTH_SHORT).show();
                    finishAffinity();
                } catch (Exception ex) {
                    Toast.makeText(this, ex + "", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLoginFaceBook_LoginActivity:
                try {
//                    intentLoginFaceBook();
                } catch (Exception ex) {
                    Toast.makeText(this, ex + "", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLoginGoogle_LoginActivity:
                try{
//                    intentLoginFaceBook();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnLoginUser_LoginActivity:
                try{
                    intentLoginActivityMenu();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void intentLoginActivityMenu() {
        Intent intent = new Intent(LoginActivity.this,Main_Menu_Activity.class );
        startActivity(intent);
    }

    private void intentLoginFaceBook() {

    }
}
