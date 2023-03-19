package com.example.classes.cells;

public class DeadCell extends CellMy {
    
    private int numberOfDead = 0;
    private int numberOfDeadInIteration = 0;

    // singleton
    private static DeadCell instance;
    public static DeadCell getInstance() {
        if (instance == null) {
            instance = new DeadCell();
        }
        return instance;
    }

    public void addDead(int numberOfDead) {
        this.numberOfDead += numberOfDead;
    }

    public int getNumberOfDead() {
        return numberOfDead;
    }

    public void setNumberOfDead(int numberOfDead) {
        this.numberOfDead = numberOfDead;
    }

    public int getNumberOfDeadInIteration() {
        return this.numberOfDeadInIteration;
    }

    public void setNumberOfDeadInIteration(int numberOfDeadInIteration) {
        this.numberOfDeadInIteration = numberOfDeadInIteration;
    }

    
}
