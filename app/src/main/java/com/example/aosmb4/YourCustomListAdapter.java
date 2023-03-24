package com.example.aosmb4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class YourCustomListAdapter extends ArrayAdapter<Doctor> {
    private LayoutInflater inflater;
    private int layout;
    private List<Doctor> items;
    public YourCustomListAdapter(Context context, int resource,
                                 List<Doctor> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view=inflater.inflate(this.layout, parent, false);
        Doctor doctor = items.get(position);
        TextView textView = view.findViewById(R.id.textElementsList);
        textView.setText(doctor.getDoctorname());
        ImageView imageView = view.findViewById(R.id.imageElementsList);
        imageView.setImageResource(doctor.getAvatar());
        return view;
    }
}
