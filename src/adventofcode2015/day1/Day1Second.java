package src.adventofcode2015.day1;

import java.util.List;

import src.lib.FileHandler;

public class Day1Second {
    public static void main(String[] args) {
        String[] inputPath = { "day1", "input.txt" };
        List<String> lines = FileHandler.readByLine(2015, inputPath);
        String line = lines.get(0);

        int floor = 0;
        int step = 0;

        while (floor >= 0 && step < line.length()) {
            floor = floor + (line.charAt(step) == '(' ? 1 : -1);
            step++;
        }

        System.out.println("Santa will enter the basement in step " + step);

    }
}