package com.example.cuteanimals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdapter extends android.widget.BaseAdapter {

    private final ListViewClickListener listener;
    Context context;
    String[] animalList;
    int[] imagesList;
    LayoutInflater inflater;
    int position;

    public listAdapter(Context context, String[] animals, int[] images, ListViewClickListener listener) {
        this.context = context;
        this.animalList = animals;
        this.imagesList = images;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return animalList.length;
    }

    @Override
    public Object getItem(int i) {
        return this.getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_list, null);
        TextView textView = view.findViewById(R.id.textView);
        ImageView animalImage = view.findViewById(R.id.imageIcon);
        textView.setText(animalList[position]);
        animalImage.setImageResource(imagesList[position]);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, position);
            }
        });
        this.position = position;

        return view;
    }

    public interface ListViewClickListener{
        void onClick(View view, int position);
    }
}
