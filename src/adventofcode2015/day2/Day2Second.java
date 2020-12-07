package src.adventofcode2015.day2;

import java.util.Arrays;
import java.util.List;

import src.lib.FileHandler;

public class Day2Second {
    public static void main(String[] args) {
        String[] inputPath = { "day2", "input.txt" };
        List<String> lines = FileHandler.readByLine(2015, inputPath);

        int result = 0;
        for (String line : lines) {
            int[] dimensions = Arrays.stream(line.split("x")).mapToInt(Integer::parseInt).sorted().toArray();
            int l = dimensions[0];
            int w = dimensions[1];
            int h = dimensions[2];

            result += (2 * l + 2 * w) + (l * w * h);

        }

        System.out.println("Total feet of ribbon they sould order : " + result);
    }
}