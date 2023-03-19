package com.example.methods;

import com.example.classes.cells.BorderMy;
import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;
import com.example.classes.cells.childs.BabyCell;
import com.example.classes.cells.childs.TeenCell;
import com.example.classes.config.Config;

// double smertnost = (16.7 / 1000);
// double birth = (9.6 / 1000);

public class Streams {

    public static void calcBirth(BabyCell cell, CellMy[][] cells) {
        double birthRate = Config.getInstance().getBirthRate();

        int fertPopulation = 0;

        // Расчет количества фертильного населения
        // Фертильное население возрастом с 16 по 49 лет
        for (int j = 15; j < 49; j++) {
            fertPopulation += cells[cell.getStrata()][j].getPopulation();
        }


        int birth = (int) Math.floor(fertPopulation * birthRate);

        cell.addTempPopulation(birth);

    }

    public static void setNewState(CellMy cell) {

        cell.setPopulationFromTemp();

    }

    // Для клеток с 15 по 100
    public static void calcStreams(CellMy cell, CellMy[][] cells) {

        // System.out.println(1);
        int migratePopulation = 0;

        migratePopulation += calcDeathStream(cell);

        if (cell.getUpNeighbour() instanceof BorderMy) {
            migratePopulation += calcUpStream(cell, (BorderMy) cell.getUpNeighbour());
        } else {
            migratePopulation += calcUpStream(cell, cell.getUpNeighbour());
        }
        if (cell.getDownNeighbour() instanceof BorderMy) {
            migratePopulation += calcDownStream(cell, (BorderMy) cell.getDownNeighbour());
        } else {
            migratePopulation += calcDownStream(cell, cell.getDownNeighbour());
        }
        

        if (cell.getDirectNeighbour() instanceof BorderMy) {
            calcDirectStream(cell, (BorderMy) cell.getDirectNeighbour(), cell.getPopulation() - migratePopulation);
        } else {
            calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation() - migratePopulation);
        }

    }

    // Для клеток с 2 по 14
    public static void calcStreams(TeenCell cell, CellMy[][] cells) {

        // System.out.println(2);
        int migratePopulation = 0;

        migratePopulation += calcDeathStream(cell);

        calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation() - migratePopulation);

    }

    // Для клеток с 1
    public static void calcStreams(BabyCell cell, CellMy[][] cells) {

        // System.out.println(3);
        calcBirth(cell, cells);

        int migratePopulation = 0;

        migratePopulation += calcDeathStream(cell);

        calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation() - migratePopulation);

    }

    public static int calcUpStream(CellMy cellFromMigrate, CellMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getUpNeighbourWeight());

        cellToMigrate.addTempPopulation(stream);

        return stream;
    }

    // метод для границы
    public static int calcUpStream(CellMy cellFromMigrate, BorderMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getUpNeighbourWeight());

        cellFromMigrate.getDirectNeighbour().addTempPopulation(stream);

        return stream;
    }

    public static int calcDownStream(CellMy cellFromMigrate, CellMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getDownNeighbourWeight());

        cellToMigrate.addTempPopulation(stream);

        return stream;
    }

    public static void calcDirectStream(CellMy cellFromMigrate, CellMy cellToMigrate, int remainedPopulation) {

        cellToMigrate.addTempPopulation(remainedPopulation);

    }

    // метод для правой границы
    public static void calcDirectStream(CellMy cellFromMigrate, BorderMy cellToMigrate, int remainedPopulation) {

        DeadCell.getInstance().addDead(remainedPopulation);
    }

    // метод для границы
    public static int calcDownStream(CellMy cellFromMigrate, BorderMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getDownNeighbourWeight());

        cellFromMigrate.getDirectNeighbour().addTempPopulation(stream);

        return stream;
    }

    public static int calcDeathStream(CellMy cell) {
        // TODO: подумать над тем как округлять
        final double deathRate = Config.getInstance().getDeathRate();

        int population = cell.getPopulation();

        int numberOfDead = (int) Math.floor(population * deathRate);
        DeadCell.getInstance().addDead(numberOfDead);

        return numberOfDead;
    }

}
