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
    String[] animalDescriptions = {"Bearded tamarin monkeys are squirrel-sized animals that are very social, and live in large groups in Peru and the southern Amazon Basin.",
            "Black-footed cats are the smallest species of wild cat, weighing between 3 and 5 pounds. They live in southern Africa, and are both solitary and strictly nocturnal. The cats can kill as many as 14 small animals in a single night.",
            "Fennec foxes are playful and social creatures that live in the sandy Sahara and North Africa. They are the smallest of the world's foxes at 9-16 inches, and use their 6-inch-long ears to radiate body heat and keep cool.",
            "Pygmy hippopotamuses spend most of their lives underwater, and weigh between 400 to 600 pounds (a regular hippopotamus can weigh as much as 6 tons). Native to the forests and swamps of West Africa, the World Conservation Union estimates that there are fewer than 3,000 pygmy hippos left in the wild.",
            "Most hummingbirds are 3 to 5 inches long, with some weighing less than a penny. They live in the Americas, and can flap their wing 50-200 times per second and fly as fast as 34 miles per hour.",
            "When a mandarin duckling hatches, its mother has to coax it to jump out of a tree. The colorful ducks live in southeast Asia, Great Britain, and some parts of North America.",
            "Quokkas are one of the smallest species of the marsupial macropod family, and weigh only five to 11 pounds (about the size of a domestic cat). They live in western Australia, and though they seem super cuddly and fun, they are ruthless survivors.",
            "Sea otters live in kelp forests on the coasts of the Northern Pacific Ocean, and often hold hands to keep from drifting away from each other. They float on their backs to crack open shellfish with rocks, making them one of the few species of mammals to use tools.",
            "Sea turtles live for up to 150 years, but throughout their whole lives, they remember the beach where they were born. They can weigh up to 400 pounds, and live in tropical and subtropical oceans worldwide.",
            "Wombats are a solitary and pudgy nocturnal marsupial. They live in Australia's grasslands and eucalyptus forests in burrows and tunnels that they dig with their claws."};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_insight);
        TextView nameText = findViewById(R.id.textView2);
        TextView description = findViewById(R.id.description);
        ImageView animalImage = findViewById(R.id.imageIcon2);

        String animal = "No animal name set";
        int image = 0;
        int position = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            animal = extras.getString("Animal");
            image = extras.getInt("Image");
            position = extras.getInt("position");
        }

        nameText.setText(animal);
        description.setText(animalDescriptions[position]);
        animalImage.setImageResource(image);
    }
}
