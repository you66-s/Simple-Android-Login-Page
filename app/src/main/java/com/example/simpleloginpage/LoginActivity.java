package com.example.simpleloginpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private User user;
    private Button Login_btn;
    private EditText Email, Pass;
    private TextView Create_Acc, Forget_Pass;
    private String Email_Returned, pass_Returned, phone_nbr_Returned, name_Returned, email_Entred, pass_Entred;
    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Create_Acc = (TextView) findViewById(R.id.Create_Acc_txt);
        Login_btn = (Button) findViewById(R.id.Login_btn);
        Email = (EditText) findViewById(R.id.Email_Field);
        Pass = (EditText) findViewById(R.id.Pass_Field);

                Create_Acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Signup_intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivityForResult(Signup_intent, REQUEST_CODE);
            }
        });
        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_Entred = Email.getText().toString();
                pass_Entred = Pass.getText().toString();
                try{
                    if ((email_Entred.equals(Email_Returned)) && (pass_Entred.equals(pass_Returned))){
                        Toast.makeText(LoginActivity.this, "Succes", Toast.LENGTH_LONG).show();
                        Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
                        login_intent.putExtra("NAME", name_Returned);
                        login_intent.putExtra("EMAIL", Email_Returned);
                        login_intent.putExtra("PHONE_NUMBER", phone_nbr_Returned);
                        login_intent.putExtra("PASSWORD", pass_Returned);
                        startActivityForResult(login_intent, REQUEST_CODE);
                    }else {
                        Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Email_Returned = data.getStringExtra("USER_EMAIL");
                pass_Returned = data.getStringExtra("USER_PASSWORD");
                phone_nbr_Returned = data.getStringExtra("USER_PHONE_NUMBER");
                name_Returned = data.getStringExtra("USER_NAME");
            }
        }
    }
}