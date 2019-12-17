package com.example.taco_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private TextView name;
    private ToggleButton meatOrVeggies;
    private Spinner location;
    private RadioGroup sauce;
    private burritoResturant myBurrito = new burritoResturant();
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = findViewById(R.id.result);
        name = findViewById(R.id.editText);
        meatOrVeggies = findViewById(R.id.toggleButton);
        location = findViewById(R.id.spinner);
        sauce = findViewById(R.id.radioGroup);

        button = findViewById(R.id.button2);
        //create listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findBurrito(v);
            }
        };
        //add listener to button
        button.setOnClickListener(onclick);

    }



    public void makeBurrito(View view) {
        //toggle button
        boolean isVegetarian = meatOrVeggies.isChecked();

        //spinner
        String exerciseType = String.valueOf(location.getSelectedItem());

        //radio buttons
        int sauce_id = sauce.getCheckedRadioButtonId();

        //pick sport



        TextView result = findViewById(R.id.result);
        EditText editText = findViewById(R.id.editText);
        String userName = name.getText().toString();


        String dreamBurrito;
        dreamBurrito = "this is me initializing dreamBurrito";

        //check radio buttons
        if (sauce_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Don't get lost in the sauce! Pick a sauce!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


        } else { //else if they have picked a sauce
            if (isVegetarian) { //if they are vegetarian
                if (sauce_id == R.id.radioButton1) { //if they want guac
                    dreamBurrito = "peppers, jalapeños, corn and guacamole";
                }
                if (sauce_id == R.id.radioButton2) { //if they want guac
                    dreamBurrito = "peppers, jalapeños, corn and pico de gallo";
                }
                if (sauce_id == R.id.radioButton3) { //if they want guac
                    dreamBurrito = "peppers, jalapeños, corn and spicy mango salsa";
                }
            }
             else { //if they want meat
                if (sauce_id == R.id.radioButton1) {
                    dreamBurrito = "carne asada, jalapeños and guacamole ";
                }
                if (sauce_id == R.id.radioButton2) {
                    dreamBurrito = "carne asada, jalapeños and pico de gallo ";
                }
                if (sauce_id == R.id.radioButton3) {
                    dreamBurrito = "carne asada, jalapeños and spicy mango salsa ";
                }
            }

            //text view
            result.setText("Hi " + userName + "! You want a burrito with " + dreamBurrito);
        }
    }

    private void findBurrito(View view){
        Integer place = location.getSelectedItemPosition();
        myBurrito.setResturantName(place);
        String suggestedResturant = myBurrito.getResturantName();
        String suggestedResturantURL = myBurrito.getResturantURL();
        Log.i("shop suggested", suggestedResturant);
        Log.i("url suggested", suggestedResturantURL);

        Intent intent = new Intent(this,BurritoActivity.class);
        intent.putExtra("resturant", suggestedResturant);
        intent.putExtra("resturantURL", suggestedResturantURL);
        startActivity(intent);
    }

}




