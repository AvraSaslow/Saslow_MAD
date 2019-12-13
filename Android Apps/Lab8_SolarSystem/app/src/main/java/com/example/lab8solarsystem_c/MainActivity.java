package com.example.lab8solarsystem_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Spinner planetSpinner;
    private PlanetInfo explorePlanets = new PlanetInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetSpinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        //create listener
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findPlanets(v);
            }
        };
        //add listener to button
        button.setOnClickListener(onclick);
    }

    private void findPlanets(View view){
        Integer planet = planetSpinner.getSelectedItemPosition();
        explorePlanets.setplanetInfo(planet);
        String informationOnPlanet = explorePlanets.getplanetInfo();
        String linkToMoreInfo = explorePlanets.getPlanetUrl();
        Log.i("Information About ", informationOnPlanet);
        Log.i("To read more...", linkToMoreInfo);

        Intent intent = new Intent(this,PlanetActivity.class);
        intent.putExtra("coffeeShopName", informationOnPlanet);
        intent.putExtra("coffeeShopURL", linkToMoreInfo);
        startActivity(intent);

    }
}
