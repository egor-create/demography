package com.example.methods;

import com.example.classes.cells.BorderMy;
import com.example.classes.cells.CellMy;
import com.example.classes.cells.childs.BabyCell;
import com.example.classes.cells.childs.TeenCell;
import com.example.classes.config.Config;

public class Init {

    public static CellMy[][] createAndFill() {

        // Создание клеток
        CellMy[][] cells = createCells();

        // Заполнение соседей
        fillNeighbours(cells);

        return cells;

    }

    public static CellMy[][] createCells() {

        int strataCol = Config.getInstance().getStrataCol();
        int ageCol = 100;

        CellMy[][] cells = new CellMy[strataCol][ageCol];

        for (int i = 0; i < cells.length; i++) {
            int population = Config.getInstance().getDEFAULT_POPULATION();
            cells[i][0] = new BabyCell(i, 1, population);

            // TODO: сделать чтоб из файла читалось

            for (int j = 1; j < 13; j++) {
                cells[i][j] = new TeenCell(i, j + 1, population);
            }
            for (int j = 13; j < cells[i].length; j++) {
                if (j == Config.getInstance().getAgeFilled()) {
                    population = 0;
                }
                cells[i][j] = new CellMy(i, j + 1, population);
            }
        }

        return cells;

    }

    public static void fillNeighbours(CellMy[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < 99; j++) {

                if (i == 0) {
                    cells[i][j].setDownNeighbour(BorderMy.getInstance());
                } else {
                    cells[i][j].setDownNeighbour(cells[i - 1][j + 1]);
                }

                if (i == cells.length - 1) {
                    cells[i][j].setUpNeighbour(BorderMy.getInstance());
                } else {
                    cells[i][j].setUpNeighbour(cells[i + 1][j + 1]);
                }

                cells[i][j].setDirectNeighbour(cells[i][j + 1]);

            }

            cells[i][99].setUpNeighbour(BorderMy.getInstance());
            cells[i][99].setDirectNeighbour(BorderMy.getInstance());
            cells[i][99].setDownNeighbour(BorderMy.getInstance());

        }

    }

}
