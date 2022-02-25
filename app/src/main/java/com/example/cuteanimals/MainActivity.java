package com.example.cuteanimals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TextView splash = findViewById(R.id.textView3);

        recyclerButton = findViewById(R.id.recyclerButton);
        listButton = findViewById(R.id.listButton);

        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setOnClickListenerList();
                replaceFragment(new listView(getApplicationContext(),animalList, animalImages, listListener));
                splash.setVisibility(View.INVISIBLE);
                listButton.setBackgroundColor(Color.parseColor("#FF3700B3"));
                recyclerButton.setBackgroundColor(Color.parseColor("#FF6200EE"));
            }
        });

        recyclerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setOnClickListenerRecycler();
                replaceFragment(new recyclerView(animalList, animalImages, recyclerListener));
                splash.setVisibility(View.INVISIBLE);
                listButton.setBackgroundColor(Color.parseColor("#FF6200EE"));
                recyclerButton.setBackgroundColor(Color.parseColor("#FF3700B3"));
            }
        });
    }

    private void setOnClickListenerList() {
        listListener = new listAdapter.ListViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), animalDetails.class);
                intent.putExtra("Animal", animalList[position]);
                intent.putExtra("Image", animalImages[position]);
                intent.putExtra("Position", position);
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
                intent.putExtra("Position", position);
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