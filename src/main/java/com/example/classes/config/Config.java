package com.example.classes.config;

public class Config {
    
    
    private final int strataCol = 10;
    private final int ageFilled = 70;

    private final double birthRate = 0.03;
    private final double deathRate = 0.01;
    // private final double birthRate = (9.6 / 1000);
    // private final double deathRate = (1.2 / 1000);


    private final int DEFAULT_POPULATION = 1000;


    private final double upNeighbourWeight = 0.01;

    private final double downNeighbourWeight = 0.05;





    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }



    public int getStrataCol() {
        return this.strataCol;
    }


    public int getAgeFilled() {
        return this.ageFilled;
    }


    public double getBirthRate() {
        return this.birthRate;
    }


    public double getDeathRate() {
        return this.deathRate;
    }


    public int getDEFAULT_POPULATION() {
        return this.DEFAULT_POPULATION;
    }


    public double getUpNeighbourWeight() {
        return this.upNeighbourWeight;
    }


    public double getDownNeighbourWeight() {
        return this.downNeighbourWeight;
    }



}
