package com.example.methods.streams;

import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;
import com.example.classes.cells.childs.BabyCell;
import com.example.classes.config.Config;

public class BirthStream {

    public static void calcBirth(BabyCell cell, CellMy[][] cells) {

        double birthRate = Config.getInstance().getBirthRate();

        int fertPopulation = 0;

        // Расчет количества фертильного населения
        // Фертильное население возрастом с 16 по 49 лет    j c 0 начинается
        for (int j = 15; j < 49; j++) {
            fertPopulation += cells[cell.getStrata()][j].getPopulation();
        }
        
        int birth = (int) Math.floor(fertPopulation * birthRate);
        
        final double deathRate = Config.getInstance().getDeathRate();
        
        int childDeath = (int) Math.floor(birth * deathRate);
        
        DeadCell.getInstance().addDead(childDeath);

        cell.addTempPopulation(birth - childDeath);
        
    }

}
