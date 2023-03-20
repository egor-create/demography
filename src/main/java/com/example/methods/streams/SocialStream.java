package com.example.methods.streams;

import com.example.classes.cells.BorderMy;
import com.example.classes.cells.CellMy;
import com.example.classes.config.Config;

// TODO Рождаемость > Смертность > Социальный прогресс/регресс > Старение

public class SocialStream {

    public static void calcDirectStream(CellMy cellFromMigrate, CellMy cellToMigrate, int remainedPopulation) {
        cellToMigrate.addTempPopulation(remainedPopulation);
    }

    //////////////////////////////

    public static int calcUpStream(CellMy cellFromMigrate, CellMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getUpNeighbourWeight());

        cellToMigrate.addTempPopulation(stream);

        return stream;
    }

    // метод для верхней границы
    public static int calcUpStream(CellMy cellFromMigrate, BorderMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getUpNeighbourWeight());

        cellFromMigrate.getDirectNeighbour().addTempPopulation(stream);

        return stream;
    }

    //////////////////////////////////////////////

    public static int calcDownStream(CellMy cellFromMigrate, CellMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getDownNeighbourWeight());

        cellToMigrate.addTempPopulation(stream);

        return stream;
    }

    // метод для нижней границы
    public static int calcDownStream(CellMy cellFromMigrate, BorderMy cellToMigrate) {
        int population = cellFromMigrate.getPopulation();
        int stream = 0;

        stream = (int) Math.floor(population * Config.getInstance().getDownNeighbourWeight());

        cellFromMigrate.getDirectNeighbour().addTempPopulation(stream);

        return stream;
    }

}
