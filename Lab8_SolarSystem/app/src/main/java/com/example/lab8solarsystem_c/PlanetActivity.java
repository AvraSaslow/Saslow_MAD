package com.example.lab8solarsystem_c;

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

public class PlanetActivity extends AppCompatActivity {

    private String planetInfo;
    private String planetURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
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
        planetInfo = intent.getStringExtra("coffeeShopName");
        planetURL = intent.getStringExtra("coffeeShopURL");
        Log.i("planet received", planetInfo);
        Log.i("url received", planetURL);

        //update text view
        TextView messageView = findViewById(R.id.planetTextView);
        messageView.setText(planetInfo);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(planetURL));
        startActivity(intent);
    }

}
