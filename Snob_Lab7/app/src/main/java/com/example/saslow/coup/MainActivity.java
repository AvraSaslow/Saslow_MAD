package com.example.saslow.coup;

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
    private TextView coupSelection;
    private ToggleButton toggle;
    private Spinner govType;
    private RadioGroup weapons;
    private CheckBox freedomCheckBox;
    private CheckBox gloryCheckBox;
    private CheckBox wealthCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        coupSelection = findViewById(R.id.coupTextView);
        toggle = findViewById(R.id.toggleButton);
        govType = findViewById(R.id.spinner);
        weapons = findViewById(R.id.radioGroup);
        freedomCheckBox = findViewById(R.id.checkBox1);
        gloryCheckBox = findViewById(R.id.checkBox2);
        wealthCheckBox = findViewById(R.id.checkBox3);
    }

    public void Coup(View view) {
        //toggle button
        boolean britishOrFrench = toggle.isChecked();

        String government = String.valueOf(govType.getSelectedItem());

        int whatWeapon = weapons.getCheckedRadioButtonId();

        Boolean freedom = freedomCheckBox.isChecked();
        Boolean glory = gloryCheckBox.isChecked();
        Boolean wealth = wealthCheckBox.isChecked();


        String shouldYouOverthrow;

        //check radio buttons
        if (whatWeapon == -1) {
            Context context = getApplicationContext();
            CharSequence text = "Please select what weapons you have";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            if (britishOrFrench) {
                if ((whatWeapon == R.id.radioButton1) || (whatWeapon == R.id.radioButton2) || (whatWeapon == R.id.radioButton3)) { //if the have guns
                    shouldYouOverthrow = "You should not overthrow, the French always lose";

                } else {
                    switch (government) {
                        case "Current government is a dictatorship":
                            shouldYouOverthrow = "Definitely try to overthrow";
                            break;
                        case "Current government is a monarchy":
                            shouldYouOverthrow = "If you are a royal, definitely try to overthrow";
                            break;
                        case "Current government is a democracy":
                            shouldYouOverthrow = "Probably don't overthrow, just run for office?";
                            break;
                        case "Current government is communist":
                            shouldYouOverthrow = "Try to overthrow, know you will probably fail";
                            break;
                        default:
                            shouldYouOverthrow = "deafult";
                    }
                }
            } else { //if they have bombs
                if ((whatWeapon == R.id.radioButton1) || (whatWeapon == R.id.radioButton3)) {
                    if (freedom) {
                        shouldYouOverthrow = "You should overthrow, you might get freedom";//academics
                    }
                    else if (glory) {
                        shouldYouOverthrow = "You probably won't get glory; you shouldn't overthrow";//culture
                    }
                    else if (wealth) {
                        shouldYouOverthrow = "You definitely won't get wealthy; don't overthrow";//tech
                    }else {
                        shouldYouOverthrow = "defalut";
                    }

                }

                else {
                    switch (government) {
                        case "Current government is a dictatorship":
                            shouldYouOverthrow = "Definitely try to overthrow";
                            break;
                        case "Current government is a monarchy":
                            shouldYouOverthrow = "If you are a royal, definitely try to overthrow";
                            break;
                        case "Current government is a democracy":
                            shouldYouOverthrow = "Probably don't overthrow, just run for office?";
                            break;
                        case "Current government is communist":
                            shouldYouOverthrow = "Try to overthrow, know you will probably fail";
                            break;
                        default:
                            shouldYouOverthrow = "deafult";
                    }
                }
                if ((whatWeapon == R.id.radioButton1) || (whatWeapon == R.id.radioButton2) || (whatWeapon == R.id.radioButton3)) {
                    switch (government) {
                        case "Current government is a dictatorship":
                            shouldYouOverthrow = "Definitely try to overthrow";
                            break;
                        case "Current government is a monarchy":
                            shouldYouOverthrow = "If you are a royal, definitely try to overthrow";
                            break;
                        case "Current government is a democracy":
                            shouldYouOverthrow = "Probably don't overthrow?";
                            break;
                        case "Current government is communist":
                            shouldYouOverthrow = "Try to overthrow, know you will probably fail";
                            break;
                        default:
                            shouldYouOverthrow = "hoogieboogie";
                    }
                }

            }

            //text view
            coupSelection.setText(shouldYouOverthrow);
        }
    }
}
