package src.adventofcode2020.day1;

import java.util.List;

import src.lib.FileHandler;

public class Day1Second {
    public static void main(String[] args) {
        String[] inputPath = { "day1", "input.txt" };
        List<String> lines = FileHandler.readByLine(inputPath);

        int firstNum = 0;
        int secondNum = 0;
        int thirdNum = 0;
        int i = 0;
        int j = 1;
        int k = 2;
        boolean found = false;

        for (i = 0; i < lines.size() - 2 && !found; i++) {
            for (j = i + 1; j < lines.size() - 1 && !found; j++) {
                for (k = j + 1; k < lines.size() && !found; k++) {
                    firstNum = Integer.parseInt(lines.get(i));
                    secondNum = Integer.parseInt(lines.get(j));
                    thirdNum = Integer.parseInt(lines.get(k));

                    found = firstNum + secondNum + thirdNum == 2020;
                }
            }
        }

        System.out.println("The three found number is on index [" + i + "," + j + "," + k + "]: " + firstNum + " and " + secondNum + " and " + thirdNum);
        System.out.println("The result is: " + (firstNum * secondNum * thirdNum));

    }
}