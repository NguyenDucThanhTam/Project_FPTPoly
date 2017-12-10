package com.example.rs.project_result_mob;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragment_Profile extends Fragment {

    FirebaseDatabase database;
    DatabaseReference nut_ten;
    EditText et;
    TextView tv;
    Button bt;
    TextView lvshow;
    EditText edtaddress, edtname, edtnumber, edtbloodtype;
    RadioButton radyes, radno;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment__profile, container, false);
        tv = (TextView) view.findViewById(R.id.lvshow);
        bt = (Button) view.findViewById(R.id.btnadd_profile);
        edtname = (EditText) view.findViewById(R.id.edtname_profile);
        edtaddress = (EditText) view.findViewById(R.id.edtaddress_profile);
        edtnumber = (EditText) view.findViewById(R.id.edtnumber_profile);
        edtbloodtype = (EditText) view.findViewById(R.id.edtbloodtype_profile);
        radno = (RadioButton) view.findViewById(R.id.radno);
        radyes = (RadioButton) view.findViewById(R.id.radyes);

        database = FirebaseDatabase.getInstance();
        nut_ten = database.getReference("message");


        //doc du lieu tu database len
        nut_ten.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tv.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtname.setEnabled(false);
                edtbloodtype.setEnabled(false);
                edtnumber.setEnabled(false);
                radyes.setEnabled(false);
                edtaddress.setEnabled(false);

                nut_ten.setValue(edtname.getText().toString() + "\n"
                        + edtaddress.getText().toString() + "\n"
                        + edtnumber.getText().toString() + "\n"
                        + edtbloodtype.getText().toString() + "\n"
                        + radyes.getText().toString());

            }
        });
        return view;
//
//
    }


}

