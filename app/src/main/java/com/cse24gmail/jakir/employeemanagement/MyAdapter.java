package com.cse24gmail.jakir.employeemanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 6/18/2016.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> list;

    public MyAdapter(Context context, ArrayList<Employee> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        if(convertView==null){
            convertView=inflater.inflate(R.layout.sample,null);
        }
        TextView tvName= (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(list.get(position).getName());

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=list.get(position).getId();
                Intent details=new Intent(context,DetailsActivity.class);
                details.putExtra("id",id);
                context.startActivity(details);
            }
        });
        return convertView;
    }
}
