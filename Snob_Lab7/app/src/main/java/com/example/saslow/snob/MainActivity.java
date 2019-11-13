package com.example.saslow.snob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView snobSelection;
    private ToggleButton toggle;
    private Spinner travel;
    private RadioGroup interest;
    private CheckBox foodCheckBox;
    private CheckBox coffeeCheckBox;
    private CheckBox artCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        snobSelection = findViewById(R.id.sportTextView);
        toggle = findViewById(R.id.toggleButton);
        travel = findViewById(R.id.spinner);
        interest = findViewById(R.id.radioGroup);
        foodCheckBox = findViewById(R.id.checkBox1);
        coffeeCheckBox = findViewById(R.id.checkBox2);
        artCheckBox = findViewById(R.id.checkBox3);
    }

    public void findSport(View view) {
        //toggle button
        boolean location = toggle.isChecked();

        //spinner
        String placesTravelled = String.valueOf(travel.getSelectedItem());

        //radio buttons
        int kindOfSnob = interest.getCheckedRadioButtonId();

        //check boxes
        Boolean food = foodCheckBox.isChecked();
        Boolean coffee = coffeeCheckBox.isChecked();
        Boolean art = artCheckBox.isChecked();

        //pick sport
        String snobType;

        //check radio buttons
        if (kindOfSnob == -1) {
            Context context = getApplicationContext();
            CharSequence text = "Please select what interests you most";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (location) { //yes they travel
                if (kindOfSnob == R.id.radioButton1) { //cheapest option
                    snobType = "A home workout";
                } else {
                    switch (placesTravelled) {
                        case "Europe":
                            snobType = "You are an art snob";
                            break;
                        case "South America":
                            snobType = "You are a spanish snob";
                            break;
                        case "Africa":
                            snobType = "You are an wildlife snob";
                            break;
                        case "Asia":
                            snobType = "You are an motorcycle snob";
                            break;
                        default:
                            snobType = "You are a snob";
                    }
                }
            } else { //no they don't travel
                if (kindOfSnob == R.id.radioButton3) {
                    if (food) {
                        snobType = "You return food at resturants";//academics
                    }
                    if (coffee) {
                        snobType = "You only drink coffee it it's from Guatemala and made in a pour-over";//culture
                    }
                    if (art) {
                        snobType = "You comment on people's art when you enter their house";//tech
                    }else {
                        snobType = "You're a snob";
                    }
                } else {
                    switch (placesTravelled) {
                        case "Europe":
                            snobType = "You are an Oxford snob";
                            break;
                        case "South America":
                            snobType = "You're a University of São Paulo snob";
                            break;
                        case "Africa":
                            snobType = "You're a University of Cape Town snob";
                            break;
                        case "Asia":
                            snobType = "You're a Hong Kong University of Science and Technology snob";
                            break;
                        default:
                            snobType = "You're too into ";
                    }
                }
            }

            //text view
            snobSelection.setText(snobType);
        }
    }
}
