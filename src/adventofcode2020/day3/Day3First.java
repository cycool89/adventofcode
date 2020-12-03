package src.adventofcode2020.day3;

import java.util.List;

import src.lib.FileHandler;

public class Day3First {
    public static void main(String[] args) {
        String[] inputPath = { "day3", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        int x = 0;
        int y = 0;

        int treeCount = 0;

        while (y < lines.size()) {
            String line = lines.get(y);

            if (line.charAt(x) == '#') {
                treeCount++;
            }

            x = (x + 3) % line.length();
            y += 1;
        }

        System.out.println("Found " + treeCount + " tree on the path!");
    }
}