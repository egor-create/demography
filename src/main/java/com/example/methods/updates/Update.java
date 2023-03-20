package com.example.methods.updates;

import com.example.classes.cells.CellMy;
import com.example.classes.cells.childs.BabyCell;
import com.example.classes.cells.childs.TeenCell;
import com.example.methods.streams.Streams;

public class Update {

    public static void calcIteration(CellMy[][] cells) {

        calcChanges(cells);
        acceptChanges(cells);

    }

    public static void calcChanges(CellMy[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] instanceof BabyCell) {
                    Streams.calcBabyCellStreams((BabyCell) cells[i][j], cells);
                } else if (cells[i][j] instanceof TeenCell) {
                    Streams.calcStreams((TeenCell) cells[i][j], cells);
                } else {
                    Streams.calcStreams(cells[i][j], cells);
                }
            }
        }
    }

    public static void acceptChanges(CellMy[][] cells) {

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                setNewState(cells[i][j]);
            }
        }
    }

    public static void setNewState(CellMy cell) {
        cell.setPopulationFromTemp();
    }

}
