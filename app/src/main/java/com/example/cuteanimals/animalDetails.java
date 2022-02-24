package com.example.cuteanimals;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class animalDetails extends AppCompatActivity {

    int[] animalImages = {R.drawable.bearded_tamarin_monkey, R.drawable.black_footed_cat, R.drawable.fennec_foxes,
            R.drawable.hippopotamuses, R.drawable.hummingbirds, R.drawable.mandarin_duckling,
            R.drawable.quokka, R.drawable.sea_otters, R.drawable.sea_turtles, R.drawable.wombat};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_insight);
        TextView nameText = findViewById(R.id.textView2);
        ImageView animalImage = findViewById(R.id.imageIcon2);

        String animal = "No animal name set";
        int image = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            animal = extras.getString("Animal");
            image = extras.getInt("Image");

        }

        nameText.setText(animal);
        animalImage.setImageResource(image);
    }
}
