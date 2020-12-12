package src.adventofcode2020.day10;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day10Second {

    public static void main(String[] args) {
       RunningTime.start();

        String[] inputPath = { "day10", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);
        int[] input = lines.stream().mapToInt(Integer::parseInt).sorted().toArray();

        long variationCount = backtrack(input, 0, 0);

        System.out.println("Total number of distinct ways: "
                + variationCount;

        RunningTime.check();
    }
    
    private static long backtrack(int[] input, int prev, int i) {
     if (i >= input.length) {
      return 1L;
     }
     if (input[i] - prev > 3) {
      return 0L;
     }
     
     long count = 0;
     count += backtrack(input, input[i], i + 1);
     count += backtrack(input, input[i], i + 2);
     count += backtrack(input, input[i], i + 3);
     
     return count;
    }
}