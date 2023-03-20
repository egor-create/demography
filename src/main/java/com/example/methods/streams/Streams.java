package com.example.methods.streams;

import com.example.classes.cells.BorderMy;
import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;
import com.example.classes.cells.childs.BabyCell;
import com.example.classes.cells.childs.TeenCell;

// TODO Рождаемость > Смертность > Социальный прогресс/регресс > Старение

public class Streams {

    // Для клеток с 1
    public static void calcBabyCellStreams(BabyCell cell, CellMy[][] cells) {

        // Рождаемость
        BirthStream.calcBirth(cell, cells);

        // Смертность на исходящие потоки
        DeathStream.calcDeathStream(cell);

        SocialStream.calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation());

    }

    // Для клеток с 2 по 14
    public static void calcStreams(TeenCell cell, CellMy[][] cells) {

        DeathStream.calcDeathStream(cell);

        SocialStream.calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation());

    }

    // Для клеток с 15 по 100
    public static void calcStreams(CellMy cell, CellMy[][] cells) {

        if (cell.getDirectNeighbour() instanceof BorderMy) {
            DeathStream.calcDeathOld(cell, (BorderMy) cell.getDirectNeighbour());
        } else {

            // Смертность
            DeathStream.calcDeathStream(cell);

            int migratePopulation = 0;

            // Потоки вверх
            if (cell.getUpNeighbour() instanceof BorderMy) {
                migratePopulation += SocialStream.calcUpStream(cell, (BorderMy) cell.getUpNeighbour());
            } else {
                migratePopulation += SocialStream.calcUpStream(cell, cell.getUpNeighbour());
            }

            // Потоки вниз
            if (cell.getDownNeighbour() instanceof BorderMy) {
                migratePopulation += SocialStream.calcDownStream(cell, (BorderMy) cell.getDownNeighbour());
            } else {
                migratePopulation += SocialStream.calcDownStream(cell, cell.getDownNeighbour());
            }

            // Оставшееся уходит в след клетку без смены страты
            SocialStream.calcDirectStream(cell, cell.getDirectNeighbour(), cell.getPopulation() - migratePopulation);

        }
    }

}
