package src.adventofcode2020.day12;

import java.util.List;

import src.lib.FileHandler;

public class Day12Second {
    public static void main(String[] args) {
        String[] inputPath = { "day12", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Ship ship = new Ship();

        for (String line : lines) {
            Direction dir = InputConverter.getDirection(line);
            int unit = InputConverter.getUnit(line);

            ship.doEvasiveActionForPartTwo(dir, unit);
        }

        System.out.println("The ship's manhattan distance is " + ship.getManhattanDistance());

    }
}