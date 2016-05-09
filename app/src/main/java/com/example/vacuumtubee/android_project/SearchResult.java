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
public class SearchResult extends AppCompatActivity {
    ListView lvList;
    ArrayList<WorkerSearchResult> items = new ArrayList<WorkerSearchResult>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);

        items.add(new WorkerSearchResult("Rahim","01234567890","Dhanmondi"));
        items.add(new WorkerSearchResult("Karim","01234567850","Dhanmondi"));
        lvList = (ListView) findViewById(R.id.lvSearchResult_list);
        final AmaderAdapter adpt = new AmaderAdapter();
        lvList.setAdapter(adpt);



        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    public class AmaderAdapter extends ArrayAdapter<WorkerSearchResult>
    {
        public AmaderAdapter()
        {
            super(getApplicationContext(), R.layout.worker_list_layout, items);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View amaderView = convertView;
            if (amaderView == null)
            {
                amaderView = getLayoutInflater().inflate(R.layout.worker_list_layout, parent, false);
            }

            TextView t1 = (TextView) amaderView.findViewById(R.id.tvName);
            TextView t2 = (TextView) amaderView.findViewById(R.id.tvPhone);
            TextView t3 = (TextView) amaderView.findViewById(R.id.tvAddress);
            Button btnReview = (Button) amaderView.findViewById(R.id.btn_worker_result_seeReview);

            btnReview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), WorkerReview.class));
                }
            });

            btnReview.setFocusable(false);

            t1.setText(items.get(position).name);
            t2.setText(items.get(position).phoneNumber);
            t3.setText(items.get(position).address);
            return amaderView;
        }
    }
}
