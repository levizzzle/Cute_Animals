package com.example.cuteanimals;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class listView extends Fragment {

    View view;
    ListView listView;
    Context context;
    listAdapter.ListViewClickListener listener;

    String[] animalList;
    int[] animalImages;


    public listView(Context context, String[] animals, int[] images, listAdapter.ListViewClickListener listener) {
        this.animalList = animals;
        this.animalImages = images;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_view, container, false);
        listView = view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setOnClickListenerList();
            }
        });

        listAdapter listAdapter = new listAdapter(context, animalList, animalImages, listener);
        listView.setAdapter(listAdapter);
        return view;
    }

    public void setOnClickListenerList() {
        listener = new listAdapter.ListViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(context, animalDetails.class);
                intent.putExtra("Animal", animalList[position]);
                intent.putExtra("Image", animalImages[position]);
                context.startActivity(intent);
            }
        };
    }
}