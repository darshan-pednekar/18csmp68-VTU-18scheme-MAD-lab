package com.example.login_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText Signup_username, Signup_password;
    Button btnsignup;
    String regularExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Signup_username = (EditText) findViewById(R.id.Signup_Username);
        Signup_password = (EditText) findViewById(R.id.Signup_Password);
        btnsignup = (Button) findViewById(R.id.btnSignup);
        btnsignup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String username = Signup_username.getText().toString();
        String password = Signup_password.getText().toString();
        if (validatePassword(password)) {
            Toast.makeText(getBaseContext(), "Valid Password", Toast.LENGTH_LONG).show();
            Bundle bundle = new Bundle();
            bundle.putString("User", username);
            bundle.putString("Pwd", password);
            Intent it=new Intent(this,login.class);
            it.putExtra("data", bundle);
            startActivity(it);

        } else {
            Toast.makeText(getBaseContext(), "invalid password",Toast.LENGTH_LONG).show();
        }
    }
    private boolean validatePassword(String password){
        Pattern pattern=Pattern.compile(regularExpression);
        Matcher matcher=pattern.matcher(password);
        return matcher.matches();
    }
}