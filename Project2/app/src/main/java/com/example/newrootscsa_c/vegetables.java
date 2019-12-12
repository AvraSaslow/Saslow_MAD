package com.example.newrootscsa_c;


/**
 * {@link vegetables} represents type of desert.
 * Each object has 2 properties: name, and number
 */

public class vegetables {
    // Name of the vegetable
    private String vegetableName;

    // Number of vegetables
    private int vegetableNumber;

    /*
     * Create a new dessert object.
     *
     * @param vName is the name of the dessert
     * @param vNumber is the corresponding number of desserts
     * @param image is drawable reference ID that corresponds to the dessert
     * */
    public vegetables(String vName, int vNumber)

    {
        vegetableName = vName;
        vegetableNumber = vNumber;

    }

    /**
     * Get the name of the dessert
     */
    public String getVegetableName() {
        return vegetableName;
    }

    /**
     * Get the  number of desserts
     */
    public int getVegetableNumber() {
        return vegetableNumber;
    }


}