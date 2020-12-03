package src.adventofcode2020.day2;

import java.util.List;

import src.lib.FileHandler;

public class Day2First {
    public static void main(String[] args) {
        String[] inputPath = { "day2", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        int validLinesCount = 0;

        for (String line : lines) {
            String[] data = line.split(":");
            String minmax = data[0].split(" ")[0];
            int min = Integer.parseInt(minmax.split("-")[0]);
            int max = Integer.parseInt(minmax.split("-")[1]);
            int neededChar = data[0].split(" ")[1].charAt(0);

            long neededCharCount = data[1].chars().filter(ch -> ch == neededChar).count();
            if (neededCharCount >= min && neededCharCount <= max) {
                validLinesCount++;
            }
        }

        System.out.println("There are " + validLinesCount + " valid lines!");
    }
}