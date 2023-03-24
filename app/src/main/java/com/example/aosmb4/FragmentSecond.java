package com.example.aosmb4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentSecond extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentsecond, container, false);
        List<Doctor> itemList = new ArrayList<Doctor>();
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);

        for(int i = 0; i < 300; i++) {
            Doctor doctor = new Doctor();
            doctor.setAvatar(R.drawable.ava);
            doctor.setDoctorname("Фамилия имя отчество Специальность ");
            itemList.add(doctor);
        }

        YourCustomRecyclerViewAdapter yourcustomrecyclerviewadapter = new YourCustomRecyclerViewAdapter(getContext(), itemList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(yourcustomrecyclerviewadapter);
        return view;
    }
}
