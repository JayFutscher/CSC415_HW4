package com.example.futscherj2_homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    private TextView etName;
    private TextView etEmail;
    private TextView etPassword;

    private Button save_Button;
    private Button retrieve_button;
    private Button clear_Button;

    public static final String SHARED_PREFS = "sharedPrefs";

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etName  = (EditText) findViewById(R.id.etName);
        etEmail  = (EditText) findViewById(R.id.etEmail);
        etPassword  = (EditText) findViewById(R.id.etPassword);



        save_Button = (Button) findViewById(R.id.save_button);
        retrieve_button = (Button) findViewById(R.id.retrieve_button);
        clear_Button = (Button) findViewById(R.id.clear_button);


        save_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });


        retrieve_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrieve();
            }
        });

        clear_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clear();
            }
        });
    }

    public void Save(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(NAME,  etName.getText().toString());
        editor.putString(EMAIL, etEmail.getText().toString());
        editor.putString(PASSWORD, etPassword.getText().toString());

        editor.commit();


    }

    public void Retrieve(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


        etName.setText(sharedPreferences.getString(NAME, ""));
        etEmail.setText(sharedPreferences.getString(EMAIL,""));
        etPassword.setText(sharedPreferences.getString(PASSWORD,""));

    }





    public void Clear(){

        etName.setText("");
        etEmail.setText("");
        etPassword.setText("");
    }

}
