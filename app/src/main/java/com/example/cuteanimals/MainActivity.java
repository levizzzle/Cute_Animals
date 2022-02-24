package com.example.cuteanimals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button listButton, recyclerButton;
    recyclerAdapter.RecyclerViewClickListener recyclerListener;
    listAdapter.ListViewClickListener listListener;

    String[] animalList = {"Bearded Tamarin Monkey", "Black Footed Cat", "Fennec Foxes",
            "Hippopotamuses", "Hummingbirds", "Mandarin Duckling", "Quokka", "Sea Otters",
            "Sea Turtles", "Wombat"};

    int[] animalImages = {R.drawable.bearded_tamarin_monkey, R.drawable.black_footed_cat, R.drawable.fennec_foxes,
            R.drawable.hippopotamuses, R.drawable.hummingbirds, R.drawable.mandarin_duckling,
            R.drawable.quokka, R.drawable.sea_otters, R.drawable.sea_turtles, R.drawable.wombat};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerButton = findViewById(R.id.recyclerButton);
        listButton = findViewById(R.id.listButton);

//        MyAdapter adapter = new MyAdapter(this, animalList, animalImages);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            }
//        });

        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setOnClickListenerList();
                replaceFragment(new listView(getApplicationContext(),animalList, animalImages, listListener));
            }
        });

        recyclerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setOnClickListenerRecycler();
                replaceFragment(new recyclerView(animalList, animalImages, recyclerListener));
            }
        });
    }

//    class MyAdapter extends ArrayAdapter<String> {
//        Context context;
//        String[] animalName;
//        int[] images;
//
//        public MyAdapter(Context context, String[] animalName, int[] images) {
//            super(context, R.layout.animal_insight, R.id.textView2, animalName);
//            this.context = context;
//            this.animalName = animalName;
//            this.images = images;
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = layoutInflater.inflate(R.layout.animal_insight, parent,false);
//            ImageView images = row.findViewById(R.id.imageIcon2);
//            TextView animalName = row.findViewById(R.id.textView2);
//
//            images.setImageResource(this.images[position]);
//            animalName.setText(this.animalName[position]);
//
//            return row;
//        }
//    }

    private void setOnClickListenerList() {
        listListener = new listAdapter.ListViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), animalDetails.class);
                intent.putExtra("Animal", animalList[position]);
                intent.putExtra("Image", animalImages[position]);
                MainActivity.this.startActivity(intent);
            }
        };
    }

    private void setOnClickListenerRecycler() {
        recyclerListener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), animalDetails.class);
                intent.putExtra("Animal", animalList[position]);
                intent.putExtra("Image", animalImages[position]);
                MainActivity.this.startActivity(intent);
            }
        };
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

}