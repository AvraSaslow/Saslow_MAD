package com.example.taco_c;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class BurritoActivity extends AppCompatActivity {

    private String resturant;
    private String resturantURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burrito);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebSite(view);
            }
        });

        Intent intent = getIntent();
        resturant = intent.getStringExtra("resturant");
        resturantURL = intent.getStringExtra("resturantURL");
        Log.i("resturant", resturant);
        Log.i("resturant url", resturantURL);

        //update text view
        TextView messageView = findViewById(R.id.resturantTextView);
        messageView.setText("The closest burrito resturant is " + resturant + ", so check out their website for directions!");

    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(resturantURL));
        startActivity(intent);
    }

}
