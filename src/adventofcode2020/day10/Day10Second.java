package src.adventofcode2020.day10;

import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

/**
 * Ez egy nagyon lassú megoldó algoritmus. Optimalizált verzió a Day10SecondOptimized.java fájlban.
 */
public class Day10Second {

    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day10", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);
        int[] input = lines.stream().mapToInt(Integer::parseInt).sorted().toArray();

        long variationCount = backtrack(input, 0, 0);
        variationCount += backtrack(input, 0, 1);
        variationCount += backtrack(input, 0, 2);

        System.out.println();
        System.out.println();
        System.out.println("Total number of distinct ways: " + variationCount);

        RunningTime.check();
    }

    private static long backtrack(int[] input, int prev, int i) {

        if (i == input.length - 1) {
            if (input[i] - prev <= 3) {
                return 1L;
            } else {
                return 0L;
            }
        }
        if (i >= input.length || input[i] - prev > 3) {
            return 0L;
        }

        long count = 0;
        count += backtrack(input, input[i], i + 1);
        count += backtrack(input, input[i], i + 2);
        count += backtrack(input, input[i], i + 3);

        return count;
    }
}