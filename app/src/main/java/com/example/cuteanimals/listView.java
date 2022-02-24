package com.example.cuteanimals;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_view, container, false);
        listView = (ListView) view.findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(context, animalList, animalImages);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listAdapter listAdapter = new listAdapter(context, animalList, animalImages, listener);
//        listView.setAdapter(listAdapter);
//        listView.setClickable(true);
        return view;
    }

    public class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] animalName;
        int[] images;

        public MyAdapter(Context context, String[] animalName, int[] images) {
            super(context, R.layout.animal_insight, R.id.textView2, animalName);
            this.context = context;
            this.animalName = animalName;
            this.images = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.animal_insight, parent,false);
            ImageView images = row.findViewById(R.id.imageIcon2);
            TextView animalName = row.findViewById(R.id.textView2);

            images.setImageResource(this.images[position]);
            animalName.setText(this.animalName[position]);

            return row;
        }
    }
}