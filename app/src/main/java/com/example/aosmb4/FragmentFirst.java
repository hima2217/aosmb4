package com.example.aosmb4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentFirst extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfirst, container, false);
        List<Doctor> itemList = new ArrayList<Doctor>();
        ListView listView = view.findViewById(R.id.listview);

        for(int i = 0; i < 300; i++) {
            Doctor doctor = new Doctor();
            doctor.setAvatar(R.drawable.ava);
            doctor.setDoctorname("Фамилия имя отчество Специальность ");
            itemList.add(doctor);
        }

        YourCustomListAdapter yourcustomlistadapter = new YourCustomListAdapter(getContext(), R.layout.elementoflist, itemList);

        listView.setAdapter(yourcustomlistadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Toast.makeText(
                        getContext(),
                        ((TextView) itemClicked.findViewById(R.id.textElementsList)).getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("ListView", (String) ((TextView) itemClicked.findViewById(R.id.textElementsList)).getText());
            }
        });
        return view;
    }
}
