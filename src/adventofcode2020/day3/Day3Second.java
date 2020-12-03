package src.adventofcode2020.day3;

import java.util.List;

import src.lib.FileHandler;

public class Day3Second {
    public static void main(String[] args) {
        String[] inputPath = { "day3", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        int multipliedTreeCounters = 1;

        multipliedTreeCounters *= Day3Second.countTrees(1, 1, lines);
        multipliedTreeCounters *= Day3Second.countTrees(3, 1, lines);
        multipliedTreeCounters *= Day3Second.countTrees(5, 1, lines);
        multipliedTreeCounters *= Day3Second.countTrees(7, 1, lines);
        multipliedTreeCounters *= Day3Second.countTrees(1, 2, lines);

        System.out.println("Found trees multiplied result is " + multipliedTreeCounters);
    }

    public static int countTrees(int slopeX, int slopeY, List<String> lines) {

        int x = 0;
        int y = 0;

        int treeCount = 0;

        while (y < lines.size()) {
            String line = lines.get(y);

            if (line.charAt(x) == '#') {
                treeCount++;
            }

            x = (x + slopeX) % line.length();
            y += slopeY;
        }

        System.out.println(treeCount + " tree found with slope (" + slopeX + ", " + slopeY + ")");

        return treeCount;
    }
}