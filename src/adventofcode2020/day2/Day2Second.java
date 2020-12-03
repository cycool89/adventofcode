package src.adventofcode2020.day2;

import java.util.List;

import src.lib.FileHandler;

public class Day2Second {
    public static void main(String[] args) {
        String[] inputPath = { "day2", "input.txt" };
        List<String> lines = FileHandler.readByLine(inputPath);

        int validLinesCount = 0;

        for (String line : lines) {
            String[] data = line.split(":");
            String positions = data[0].split(" ")[0];
            int pos1 = Integer.parseInt(positions.split("-")[0]);
            int pos2 = Integer.parseInt(positions.split("-")[1]);
            int neededChar = data[0].split(" ")[1].charAt(0);

            String password = data[1];
            if (password.charAt(pos1) == neededChar ^ password.charAt(pos2) == neededChar) {
                validLinesCount++;
            }
        }

        System.out.println("There are " + validLinesCount + " valid lines!");
    }
}