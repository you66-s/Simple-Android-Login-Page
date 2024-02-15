package com.example.simpleloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView name, email, password, phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        name = (TextView) findViewById(R.id.Name_Ret);
        email = (TextView) findViewById(R.id.Email_ret);
        phone_number = (TextView) findViewById(R.id.Phone_ret);
        password = (TextView) findViewById(R.id.pass_ret);
        Bundle extras = getIntent().getExtras();
        name.setText(extras.getString("NAME"));
        email.setText(extras.getString("EMAIL"));
        phone_number.setText(extras.getString("PHONE_NUMBER"));
        String passwordSTR = String.valueOf(extras.getString("PASSWORD").toString().hashCode());
        password.setText(passwordSTR);
    }
}