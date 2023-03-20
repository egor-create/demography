package com.example.methods.streams;

import com.example.classes.cells.BorderMy;
import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;
import com.example.classes.config.Config;

public class DeathStream {
    
    public static int calcDeathStream(CellMy cell) {
        
        final double deathRate = Config.getInstance().getDeathRate();

        int population = cell.getPopulation();

        int numberOfDead = (int) Math.floor(population * deathRate);
        
        cell.setDeath(numberOfDead);

        DeadCell.getInstance().addDead(numberOfDead);

        return numberOfDead;
    }

    // метод для правой границы
    public static void calcDeathOld(CellMy cellFromMigrate, BorderMy cellToMigrate) {
        DeadCell.getInstance().addDead(cellFromMigrate.getPopulation());
    }


}
