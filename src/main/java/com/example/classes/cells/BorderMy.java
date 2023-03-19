package com.example.classes.cells;

public class BorderMy extends CellMy {

    // singleton
    private static BorderMy instance;

    public static BorderMy getInstance() {
        if (instance == null) {
            instance = new BorderMy();
        }
        return instance;
    }

    @Override
    public String getPosition() {
        return "Border";
    }

}
