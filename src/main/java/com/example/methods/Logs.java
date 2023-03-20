package com.example.methods;

import java.io.IOException;
import java.io.PrintWriter;

import com.example.classes.cells.CellMy;
import com.example.classes.cells.DeadCell;

public class Logs {

    public static void createLog(CellMy[][] cells, int iteration, int death, int totalBirth) {

        try {
            PrintWriter writer = new PrintWriter("logs/" + iteration + ".txt", "UTF-8");

            // обратный вывод
            int from = 0;
            int to = 30;

            for (int j = from; j < to; j++) {
                // Запись в файл с пробелом после
                writer.print((j + 1) + "   ");
            }

            writer.println();
            writer.println();

            for (int i = cells.length - 1; i >= 0; i--) {
                // переверни
                for (int j = from; j < to; j++) {
                    // Запись в файл с пробелом после
                    writer.print(cells[i][j].getPopulation() + " ");
                }

                // Переход на новую строку после каждой десятки чисел
                writer.println();
            }
            writer.println("------------------------------------------------------");
            writer.println("Total Death: " + DeadCell.getInstance().getNumberOfDead());
            writer.println("Iteration Death: " + death);
            writer.println();
            if (iteration == 0) {
                writer.println("Birth: 0");
            } else {
                writer.println("Birth: " + Calc.calcBirth(cells));
            }
            writer.println("Fertil Population: " + Calc.calcTotalFertPopulation(cells));
            writer.println("Total Birth: " + totalBirth);
            writer.println();
            writer.println("Total Population: " + Calc.calcTotalPopulation(cells));
            writer.println();
            writer.println("Death + Total Population: "
                    + (Calc.calcTotalPopulation(cells) + DeadCell.getInstance().getNumberOfDead()));
            writer.println();
            writer.println("Total Population + Death - Total Birth: "
                    + (Calc.calcTotalPopulation(cells) + DeadCell.getInstance().getNumberOfDead() - totalBirth));
            writer.println("Не совпадает, ибо в смертности учитываются и мифические люди, которые появляются из воздуха и сразу умирают");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }

    }
}
