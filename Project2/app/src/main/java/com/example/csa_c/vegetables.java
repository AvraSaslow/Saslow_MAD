package com.example.csa_c;

//class to create vegetables so that it can be updated in MainActivity
public class vegetables {
    private String vegetableName; // Name of the vegetable
    private int vegetableNumber; // Number of vegetables

    public vegetables(String vName, int vNumber) { //Create a new vegetable object.
        vegetableName = vName;
        vegetableNumber = vNumber;
    }

    public String getVegetableName() {
        return vegetableName; //get name of vegetable
    }

    public int getVegetableNumber() {
        return vegetableNumber;    //get number of vegetable
    }
}