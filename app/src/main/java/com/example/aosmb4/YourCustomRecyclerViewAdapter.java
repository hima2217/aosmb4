package com.example.aosmb4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class YourCustomRecyclerViewAdapter extends RecyclerView.Adapter<YourCustomRecyclerViewAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Doctor> doctors;

    YourCustomRecyclerViewAdapter(Context context, List<Doctor> items) {
        this.doctors = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public YourCustomRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.elementoflist, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(YourCustomRecyclerViewAdapter.ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.textView.setText(doctor.getDoctorname());
        holder.imageView.setImageResource(doctor.getAvatar());

        holder.textView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        inflater.getContext(),
                        (String)holder.textView.getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("logggggg", (String)holder.textView.getText());
            }
        });
    }
    @Override
    public int getItemCount() {
        return doctors.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;

        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textElementsList);
            imageView = view.findViewById(R.id.imageElementsList);
        }
    }
}