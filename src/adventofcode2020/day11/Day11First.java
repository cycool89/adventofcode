package src.adventofcode2020.day11;

import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day11First {

    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day11", "sampleInput.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Grid grid = new Grid();
        for (String line : lines) {
            grid.addLine(line);
        }



        RunningTime.check();
    }
}