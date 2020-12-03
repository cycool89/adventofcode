package src.adventofcode2020.day1;

import java.util.List;

import src.lib.FileHandler;

public class Day1First {
    public static void main(String[] args) {
        String[] inputPath = { "day1", "input.txt" };
        List<String> lines = FileHandler.readByLine(inputPath);

        int firstNum = 0;
        int secondNum = 0;
        int i = 0;
        int j = 1;
        boolean found = false;

        for (i = 0; i < lines.size() - 1 && !found; i++) {
            for (j = i + 1; j < lines.size() && !found; j++) {
                firstNum = Integer.parseInt(lines.get(i));
                secondNum = Integer.parseInt(lines.get(j));

                found = firstNum + secondNum == 2020;
            }
        }

        System.out.println("The two found number is on index [" + i + "," + j + "]: " + firstNum + " and " + secondNum);
        System.out.println("The result is: " + (firstNum * secondNum));

    }
}