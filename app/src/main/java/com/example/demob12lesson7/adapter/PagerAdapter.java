package com.example.demob12lesson7.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demob12lesson7.R;
import com.example.demob12lesson7.model.PagerModel;

import java.util.ArrayList;

public class PagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public ArrayList<PagerModel> pagers;

    public PagerAdapter(ArrayList<PagerModel> pagers) {
        this.pagers = pagers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_pager_view, parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PagerViewHolder) {
            PagerModel pagerModel = pagers.get(position);
            ImageView circle1 = ((PagerViewHolder) holder).circle1;
            ImageView circle2 = ((PagerViewHolder) holder).circle2;
            ImageView circle3 = ((PagerViewHolder) holder).circle3;
            Button start = ((PagerViewHolder) holder).started;
            Button login = ((PagerViewHolder) holder).login;

            circle1.setImageResource(pagerModel.getCircle1());
            circle2.setImageResource(pagerModel.getCircle2());
            circle3.setImageResource(pagerModel.getCircle3());
            start.setText(pagerModel.getStart());
            login.setText(pagerModel.getLogin());
        }
    }

    @Override
    public int getItemCount() {
        return pagers.size();
    }


    class PagerViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView circle1;
        public ImageView circle2;
        public ImageView circle3;
        public Button started;
        public Button login;

        public PagerViewHolder(View v) {
            super(v);
            this.view = v;
            circle1 = view.findViewById(R.id.iv_circle1);
            circle2 = view.findViewById(R.id.iv_circle2);
            circle3 = view.findViewById(R.id.iv_circle3);
            started = view.findViewById(R.id.btn_started);
            login = view.findViewById(R.id.btn_login);
        }
    }

}
