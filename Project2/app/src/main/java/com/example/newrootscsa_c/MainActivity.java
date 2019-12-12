package com.example.newrootscsa_c;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  {


    int Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"newrootsfarmllc@gmail.com"});  //developer 's email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "CSA For Week of 7/21"); // Email 's Subject
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Sarah, the order for Avra this week is: Arugula (1), Spinach (2), Tomato (3)"

                );  //Email 's Greeting text
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
            }
        });




        // Create an ArrayList of Dessert objects
        final ArrayList<vegetables> veggies = new ArrayList<vegetables>();

        viewAdapter flavorAdapter = new viewAdapter(this, veggies);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_vegetables);
        listView.setAdapter(flavorAdapter);

        veggies.add(new vegetables("Arugula", 0));
        veggies.add(new vegetables("Spinach", 0));
        veggies.add(new vegetables("Parsley", 0));
        veggies.add(new vegetables("Carrots", 0));
        veggies.add(new vegetables("Tomato", 0));


        // Create an {@link DessertAdapter}, whose data source is a list of
        // {@link Dessert}s. The adapter knows how to create list item views for each item
        // in the list.


    }
    public void Decrement(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.vegetable_number);
        String quantityString = quantityView.getText().toString();
        Number = Integer.parseInt(quantityString);
        Number -= 1;

        if (Number < 0) {
            Number = 0;
            Toast.makeText(MainActivity.this, "Can't have an order less than 0",
                    Toast.LENGTH_LONG).show();}
        quantityView.setText(String.valueOf(Number));
    }
    public void Increment(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView quantityView = (TextView) parentRow.findViewById(R.id.vegetable_number);
        String quantityString = quantityView.getText().toString();
        Number = Integer.parseInt(quantityString);
        Number += 1;
        quantityView.setText(String.valueOf(Number));
    }

}