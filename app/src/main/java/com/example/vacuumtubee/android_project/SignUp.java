package com.example.vacuumtubee.android_project;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.net.URLEncoder;

public class SignUp extends AppCompatActivity {

    Button btnSignUp;
    EditText etname, etpassword, etphn, etlocation;
    String name, password, phn, location;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        init();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null ||  !networkInfo.isConnected() ){
            Toast.makeText(getApplicationContext(),"No Internet",Toast.LENGTH_SHORT).show();
            btnSignUp.setEnabled(false);
        }
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etname.getText().toString();
                password = etpassword.getText().toString();
                phn = etphn.getText().toString();
                location = etlocation.getText().toString();
                Background background = new Background(getApplicationContext());
                background.execute("SignUp",name,password,phn,location);
                finish();
                startActivity(new Intent(getApplicationContext(), MainPage.class));



            }
        });


    }

    private void init() {
        etname = (EditText) findViewById(R.id.etName);
        etpassword = (EditText) findViewById(R.id.etPassword);
        etphn = (EditText) findViewById(R.id.etPhone);
        etlocation = (EditText) findViewById(R.id.etSignUpLocation);
        btnSignUp = (Button) findViewById(R.id.btnSignup_signup);

    }
}



