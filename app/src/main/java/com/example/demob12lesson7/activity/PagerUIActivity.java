package com.example.demob12lesson7.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.example.demob12lesson7.R;
import com.example.demob12lesson7.adapter.PagerAdapter;
import com.example.demob12lesson7.model.PagerModel;

import java.util.ArrayList;

public class PagerUIActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_uiactivity);

        initViews();

        ArrayList<PagerModel> pagers = preparePagerList();
        refreshAdapter(pagers);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.pager_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }


    private void refreshAdapter(ArrayList<PagerModel> pagers) {
        PagerAdapter adapter = new PagerAdapter(pagers);
        recyclerView.setAdapter(adapter);
    }


    private ArrayList<PagerModel> preparePagerList() {
        ArrayList<PagerModel> pagers = new ArrayList<>();
        pagers.add(new PagerModel(R.drawable.ic_full_circle, R.drawable.ic_empty_circle, R.drawable.ic_empty_circle, 1 + ")get started", 1 + ")login"));
        pagers.add(new PagerModel(R.drawable.ic_empty_circle, R.drawable.ic_full_circle, R.drawable.ic_empty_circle, 2 + ")get started", 2 + ")login"));
        pagers.add(new PagerModel(R.drawable.ic_empty_circle, R.drawable.ic_empty_circle, R.drawable.ic_full_circle, 3 + ")get started", 3 + ")login"));
        return pagers;
    }

}