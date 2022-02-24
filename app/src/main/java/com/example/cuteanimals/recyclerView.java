package com.example.cuteanimals;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class recyclerView extends Fragment {

    private RecyclerView recyclerView;
    private recyclerAdapter.RecyclerViewClickListener listener;

    String[] animalList;
    int[] animalImages;

    public recyclerView(String[] animals, int[] images, recyclerAdapter.RecyclerViewClickListener listener) {
        this.animalList = animals;
        this.animalImages = images;
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerAdapter recyclerAdapter = new recyclerAdapter(animalList, animalImages, listener);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}