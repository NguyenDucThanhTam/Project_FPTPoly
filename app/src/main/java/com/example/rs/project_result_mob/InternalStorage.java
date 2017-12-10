package com.example.rs.project_result_mob;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.NullPointerException;


/**
 * Created by Zu.CMX on 01/12/2017.
 */

public class InternalStorage extends AppCompatActivity implements OnClickListener {
    private Button btn_send;
    private EditText Username;
    private EditText Phone;
    private EditText Email;
    private EditText Message;
    private String filename = "FeedBack.txt";
    private final String content = "FeedBack HCM";
    private android.util.Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Username = (EditText) findViewById ( R.id.Username_input_name );
        Phone = (EditText) findViewById ( R.id.Phone_input_numbers );
        Email = (EditText) findViewById ( R.id.Email_input_email );
        Message = (EditText) findViewById ( R.id.Message_input_message );
        btn_send = (Button) findViewById ( R.id.btn_send );
        btn_send.setOnClickListener ( this );
    }

    @Override
    public void onClick(View v){
        switch (v.getId ()) {
            case R.id.btn_send:
                //saveData ();
                saveDataByCache ();
                break;
        }
    }

    public void saveData() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput ( filename,Context.MODE_PRIVATE );
            fileOutputStream.write ( content.getBytes () );
            fileOutputStream.close ();
            Toast.makeText ( this,"Successfully", Toast.LENGTH_SHORT ).show ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
    public void saveDataByCache() {
        FileOutputStream fileOutputStream = null;
        File file =null;
        try {
            File file1 =new File ( getCacheDir (),filename );
            fileOutputStream = new FileOutputStream ( file );

            log.d("MainActivity",getCacheDir ().getAbsolutePath ());
            fileOutputStream.write ( content.getBytes () );
            fileOutputStream.close ();
            Toast.makeText ( this,"Successfully", Toast.LENGTH_SHORT ).show ();
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}