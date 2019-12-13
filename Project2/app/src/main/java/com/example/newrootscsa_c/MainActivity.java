package com.example.newrootscsa_c;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;


 /*

 check out milestone 3 on wordpress for more explaination

  */


public class MainActivity extends AppCompatActivity  {

    int Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Tutorial Followed to understand viewAdapter: https://appsandbiscuits.com/listview-tutorial-android-12-ccef4ead27cc
         */

        //create an instance of viewadapter, feed data in, tell list view to use it
        final ArrayList<vegetables> veggies = new ArrayList<vegetables>();
        viewAdapter addItems = new viewAdapter(this, veggies);
        final ListView listView = (ListView) findViewById(R.id.listview_vegetables);
        listView.setAdapter(addItems);


        /*
        Source for preserving state: https://medium.com/hootsuite-engineering/handling-orientation-changes-on-android-41a6b62cb43f
         */



        //use vegetables class to add new vegetables for the week
        veggies.add(new vegetables("Arugula", 0));
        veggies.add(new vegetables("Spinach", 0));
        veggies.add(new vegetables("Parsley", 0));
        veggies.add(new vegetables("Carrots", 0));
        veggies.add(new vegetables("Tomato", 0));


        /*
        Source for email FAB: https://developer.android.com/guide/components/intents-common
         */

        //Fab button for sending the email
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //takes user's input and makes it a string to pass in email
                EditText nameText = (EditText) findViewById(R.id.editTextName);
                nameText.setInputType(InputType.TYPE_CLASS_TEXT);
                String userName = nameText.getText().toString();


                Intent Email = new Intent(Intent.ACTION_SEND);

                /* ------ Map<String, Integer> veggieMap = insertEmail(listView); ------
                Trying to call function here */


                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"newrootsfarmllc@gmail.com"}); //new roots email
                Email.putExtra(Intent.EXTRA_SUBJECT,
                        "Order form for " + userName  + "");
                Email.putExtra(Intent.EXTRA_TEXT, "Dear Sarah, the order for " +
                                userName + " is ");

                /* ------ Email.putExtra("map",  veggieMap); -------
                *Trying to place my map in my intent here */


                startActivity(Intent.createChooser(Email, "CSA Order"));

            }
        });

    }


    /*Sources for trying to figure out mapping

    https://developer.android.com/reference/java/util/HashMap
    https://stackoverflow.com/questions/7578236/how-to-send-hashmap-value-to-another-activity-using-an-intent
    https://stackoverflow.com/questions/4992097/android-how-to-pass-hashmapstring-string-between-activities/4992465
    https://stackoverflow.com/questions/23991119/what-is-difference-between-liststring-list-new-arrayliststring-and-array
    https://www.callicoder.com/java-hashmap/
     */

    public Map<String, Integer> insertEmail(ListView myList){

        Map<String, Integer> veggieMap = new HashMap<String, Integer>(); //Create a hashmap to store vegetables and number ordered

        View newView;
        ArrayList<String> list = new ArrayList<String>(); //create arraylist of strings

        TextView vName;

        for (int i = 0; i < myList.getCount(); i++) { //looping over list view
            newView = myList.getChildAt(i);

            vName = (TextView) newView.findViewById(R.id.vegetable_name); //getting vegetable name
            //VNumb = (TextView) newView.findViewById(R.id.vegetable_number);

            //TextView vName = (TextView)findViewById(R.id.vegetable_name);
            //TextView numb = (TextView)findViewById(R.id.vegetable_number);

            String key = vName.getText().toString();
            if(veggieMap.containsKey(key)) { //vegetable name has a vegetable number, put it in map
                veggieMap.put(key, veggieMap.get(key) );
            }
        }
        return veggieMap; //return map

    }

    /*
    Sources for Linear Layout: https://stackoverflow.com/questions/17879743/get-parents-view-from-a-layout/17879808
     */

    public void Decrement(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView counting = (TextView) parentRow.findViewById(R.id.vegetable_number);
        String countingString = counting.getText().toString();
        Number = Integer.parseInt(countingString);
        Number -= 1;//decrement


        if (Number < 0) {
            Number = 0;
            Toast.makeText(MainActivity.this, "Can't have an order less than 0",
                    Toast.LENGTH_LONG).show();}

        counting.setText(String.valueOf(Number)); //this is after the toast so that the numbers never go negative
    }


    public void Increment(View view) {

        LinearLayout parentRow = (LinearLayout) view.getParent();

        TextView counting = (TextView) parentRow.findViewById(R.id.vegetable_number);
        String countingString = counting.getText().toString();
        Number = Integer.parseInt(countingString);
        Number += 1;//increment
        counting.setText(String.valueOf(Number));
    }

}