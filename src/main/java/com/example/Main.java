package com.example;

import java.io.File;

import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;
import com.example.methods.Init;
import com.example.methods.Logs;

public class Main {

    public static void main(String[] args) {

        // TODO возомжно сделать так, чтобы все фертильное население давало нужный процент, но вопрос надо ли


        int ITERATIONS = 9;

        CellMy[][] cells = Init.createCells();

        // Создание папки logs
        File logsFolder = new File("logs");
        String[] entries = logsFolder.list();
        for (String s : entries) {
            File currentFile = new File(logsFolder.getPath(), s);
            currentFile.delete();
        }

        logsFolder.mkdir();

        int numberOfDeadInIteration1 = 0;
        int numberOfDeadInIteration2 = 0;

        Logs.createLog(cells, 0, numberOfDeadInIteration2 - numberOfDeadInIteration1);
        for (int i = 1; i <= ITERATIONS; i++) {

            numberOfDeadInIteration1 = DeadCell.getInstance().getNumberOfDead();

            Init.calcIteration(cells);

            numberOfDeadInIteration2 = DeadCell.getInstance().getNumberOfDead();

            Logs.createLog(cells, i, (numberOfDeadInIteration2 - numberOfDeadInIteration1));

        }

    }

}
