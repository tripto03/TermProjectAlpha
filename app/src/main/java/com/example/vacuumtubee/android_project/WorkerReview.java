package com.example.vacuumtubee.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NIT on 4/25/2016.
 */
public class WorkerReview extends AppCompatActivity {
    ListView lvList;
    ArrayList<WorkerReviewResult> items = new ArrayList<WorkerReviewResult>();
    Button btnAddReview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worker_review);

        btnAddReview=(Button)findViewById(R.id.btnWorker_review_addReview);
        btnAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReviewForm.class));
            }
        });
        items.add(new WorkerReviewResult("good","2.5","Kashem"));
        items.add(new WorkerReviewResult("well ","4.5","Hamid"));
        lvList = (ListView) findViewById(R.id.lvWorker_review_list);
        final AmaderAdapter adpt = new AmaderAdapter();
        lvList.setAdapter(adpt);



        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        
        
        

    }
    public class AmaderAdapter extends ArrayAdapter<WorkerReviewResult>
    {
        public AmaderAdapter()
        {
            super(getApplicationContext(), R.layout.worker_review_list, items);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View amaderView = convertView;
            if (amaderView == null)
            {
                amaderView = getLayoutInflater().inflate(R.layout.worker_review_list, parent, false);
            }

            TextView t1 = (TextView) amaderView.findViewById(R.id.tvWorker_review_list_review);
            TextView t2 = (TextView) amaderView.findViewById(R.id.tvWorker_review_list_rating);
            TextView t3 = (TextView) amaderView.findViewById(R.id.tvWorker_review_list_employer);

            t1.setText(items.get(position).review);
            t2.setText(items.get(position).rating);
            t3.setText(items.get(position).employer);
            return amaderView;
        }
    }

}
