package com.example.methods;

import com.example.classes.cells.CellMy;

public class Calc {

    public static int calcTotalPopulation(CellMy[][] cells) {
        int totalPopulation = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                totalPopulation += cells[i][j].getPopulation();
            }
        }
        return totalPopulation;
    }

    public static int calcBirth(CellMy[][] cells) {
        int birth = 0;
        for (int i = 0; i < cells.length; i++) {
            birth += cells[i][0].getPopulation();
        }
        return birth;
    }

    
    public static int calcTotalFertPopulation (CellMy[][] cells) {
        int fertPopulation = 0;

        // Расчет количества фертильного населения
        // Фертильное население возрастом с 16 по 49 лет
        for (int i = 0; i < cells.length; i++) {
            for (int j = 15; j < 49; j++) {
                fertPopulation += cells[i][j].getPopulation();
            }
        }

        return fertPopulation;
    }



}
