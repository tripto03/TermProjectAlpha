package com.example.vacuumtubee.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by NIT on 4/25/2016.
 */
public class ReviewForm extends AppCompatActivity {

    Button btnReviews,btnSubmit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_form);
        init();
        btnReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WorkerReview.class));

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WorkerReview.class));

            }
        });
    }

    private void init() {

        btnReviews=(Button)findViewById(R.id.btnReview_form_other_review);
        btnSubmit=(Button)findViewById(R.id.btnReview_form_submit);

    }
}
