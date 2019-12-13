package com.example.newrootscsa_c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*

Tutorial Followed to understand viewAdapter: https://appsandbiscuits.com/listview-tutorial-android-12-ccef4ead27cc

 */

public class viewAdapter extends ArrayAdapter<vegetables> {

    public viewAdapter(Activity context, ArrayList<vegetables> vegetables) {
        super(context, 0, vegetables); //initialize, populate single text view,
    }

     /*
     Source for understanding what the heck layout inflaters are: https://stackoverflow.com/questions/3477422/what-does-layoutinflater-in-android-do
      */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView; //
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate( //create new view
                    R.layout.item, parent, false);
        }

        //get item
        vegetables currentVegetable = getItem(position);

        //reference vegetable name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.vegetable_name);

        //set this text to current name of vegetable
        nameTextView.setText(currentVegetable.getVegetableName());

        //reference vegetable number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.vegetable_number);

        //set this text to the current number of vegetables
        numberTextView.setText(String.valueOf(currentVegetable.getVegetableNumber()));

        return listItemView;
    }}

