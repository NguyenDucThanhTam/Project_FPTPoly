package com.example.rs.project_result_mob;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Fragment_Feedback extends Fragment {
    private Button btn_send;
    private EditText Username;
    private EditText Phone;
    private EditText Email;
    private EditText Message;
    private TextInputLayout UserNameLayout;
    private TextInputLayout PhoneLayout;
    private TextInputLayout EmailLayout;
    private TextInputLayout MessageLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.activity_fragment__feedback, container, false );
        Username = view.findViewById ( R.id.Username_input_name );
        Phone = view.findViewById ( R.id.Phone_input_numbers );
        Email = view.findViewById ( R.id.Email_input_email );
        EditText Message = view.findViewById ( R.id.Message_input_message );
        TextInputLayout UserNameLayout = view.findViewById ( R.id.Username_input_layout );
        TextInputLayout PhoneLayout = view.findViewById ( R.id.Phone_input_layout );
        TextInputLayout EmailLayout = view.findViewById ( R.id.Email_input_layout );
        TextInputLayout MessageLayout = view.findViewById ( R.id.Message_input_layout );
        Button btn_send = view.findViewById ( R.id.btn_send );

        btn_send.setOnClickListener ( new View.OnClickListener () {
                                          @Override
                                          public void onClick(View view) {
                                              CheckEditText ();
                                          }
                                      }
        );
        return view;
    }

    public void CheckEditText() {
        Toast.makeText ( getActivity (), "Successfully", Toast.LENGTH_SHORT ).show ();
        if (Username.getText ().toString ().trim ().equals ( "" )) {
            UserNameLayout.setError ( "Please enter your UserName" );

        } else {
            if (Phone.getText ().toString ().trim ().equals ( "" )) {
                PhoneLayout.setError ( "Please enter your Phone" );
            } else {
                if (Email.getText ().toString ().trim ().equals ( "" )) {
                    EmailLayout.setError ( "Please enter your Email" );
                    // Email.setBackgroundResource(R.drawable.customedittext);
                }
            }
            if (Message.getText ().toString ().trim ().equals ( "" )) {
                MessageLayout.setError ( "Please enter your Message" );
            }
        }
    }
}
