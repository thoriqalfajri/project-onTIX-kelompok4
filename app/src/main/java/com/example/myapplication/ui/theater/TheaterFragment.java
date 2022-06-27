package com.example.myapplication.ui.theater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.Theater;
import com.example.myapplication.TheaterAdapter;

import java.util.ArrayList;

public class TheaterFragment extends Fragment {
    private RecyclerView rvTheater;
    private TheaterAdapter theaterAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_theater, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTheater = view.findViewById(R.id.rv_theater);
    }

    @Override
    public void onStart() {
        super.onStart();
        theaterAdapter = new TheaterAdapter(getTheater());

        setLayout();
        getTheater();
    }

    private void setLayout(){
        rvTheater.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTheater.setHasFixedSize(true);
        rvTheater.setAdapter(theaterAdapter);
    }

    public ArrayList<Theater> getTheater() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataAddress = getResources().getStringArray(R.array.data_address);
        ArrayList<Theater> listTheater = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Theater theater = new Theater();
            theater.setName(dataName[i]);
            theater.setAddress(dataAddress[i]);
            listTheater.add(theater);
        }
        return listTheater;
    }
}