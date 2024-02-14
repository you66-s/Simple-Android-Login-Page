package com.example.simpleloginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity {
    private User user;
    private ArrayList<User> user_List;
    private EditText name, email, phone_numbre, password, conf_pass;
    private Button signup_btn;
    private TextView login_back_txt;
    private String nameSTR, emailSTR, phone_numbreSTR, passwordSTR, conf_passSTR;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //iDs assigning
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.Name_Field);
        email = (EditText) findViewById(R.id.Email_Field_Signup);
        phone_numbre = (EditText) findViewById(R.id.Phone_nbr_Field);
        password = (EditText) findViewById(R.id.Password_signup_Field);
        conf_pass = (EditText) findViewById(R.id.Conf_Password_signup_Field);
        signup_btn = (Button) findViewById(R.id.Signup_btn);
        login_back_txt = (TextView) findViewById(R.id.Login_Back_txt);
        //end of iDs assigning


        //Sign Up Functionality
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameSTR = name.getText().toString();
                checkEmpty(nameSTR, name);
                emailSTR = email.getText().toString();
                checkEmpty(emailSTR, email);
                phone_numbreSTR = phone_numbre.getText().toString();
                checkEmpty(phone_numbreSTR, phone_numbre);
                passwordSTR = password.getText().toString();
                checkEmpty(passwordSTR, password);
                if (passwordSTR.length() < 8){
                    password.setTextColor(Color.parseColor("#C75450"));
                    Toast.makeText(SignupActivity.this, "Password should be more than 8 character", Toast.LENGTH_LONG).show();
                }
                conf_passSTR = conf_pass.getText().toString();
                if (!(passwordSTR.equals(conf_passSTR))){
                    password.setTextColor(Color.parseColor("#C75450"));
                    conf_pass.setTextColor(Color.parseColor("#C75450"));
                    Toast.makeText(SignupActivity.this, "Password isn't the same", Toast.LENGTH_LONG).show();
                }
                user = new User(nameSTR, emailSTR, phone_numbreSTR, passwordSTR);
                Intent Back_intent = getIntent();
                Back_intent.putExtra("USER_EMAIL", user.getEmail());
                Back_intent.putExtra("USER_PASSWORD", user.getPassword());
                Back_intent.putExtra("USER_NAME", user.getUser_Name());
                Back_intent.putExtra("USER_PHONE_NUMBER", user.getPhone_Number());
                setResult(RESULT_OK, Back_intent);
                finish();
            }
        });
    }
    public void checkEmpty(@NonNull String txt, EditText editText){
        if (txt.isEmpty()){
            editText.setTextColor(Color.parseColor("#C75450"));
            Toast.makeText(SignupActivity.this, editText.getHint()+" is empty", Toast.LENGTH_SHORT).show();
        }
    }
}