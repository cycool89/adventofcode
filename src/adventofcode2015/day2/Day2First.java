package src.adventofcode2015.day2;

import java.util.Arrays;
import java.util.List;

import src.lib.FileHandler;

public class Day2First {
    public static void main(String[] args) {
        String[] inputPath = { "day2", "input.txt" };
        List<String> lines = FileHandler.readByLine(2015, inputPath);

        int result = 0;
        for (String line : lines) {
            int[] dimensions = Arrays.stream(line.split("x")).mapToInt(Integer::parseInt).sorted().toArray();
            int l = dimensions[0];
            int w = dimensions[1];
            int h = dimensions[2];

            result += (2 * l * w + 2 * w * h + 2 * h * l) + (l * w);

        }

        System.out.println("Total square feet of wrapping paper they sould order : " + result);

    }
}