package com.mk.michaelk.mytasks;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom extends BaseAdapter {
    private Context context;
    private ArrayList<task>taskArrayList;


    public Custom(Context context, ArrayList<task> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }


    @Override
    public int getCount() {
        return taskArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return taskArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.activity_custom,parent,false);
        }
        TextView tvCategory=convertView.findViewById(R.id.cat);

        TextView tvTitle=convertView.findViewById(R.id.tit);
        TextView tvFree=convertView.findViewById(R.id.fre);
        task Task=(task)getItem(position);
        tvCategory.setText(Task.getCategory());
        tvTitle.setText(Task.getTitle());
        tvFree.setText(Task.getFree());

        return convertView;
    }
}
