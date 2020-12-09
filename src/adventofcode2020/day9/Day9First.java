package src.adventofcode2020.day9;

import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day9First {
    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day9", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);
        long[] input = lines.stream().mapToLong(Long::parseLong).toArray();

        int preamble = 25;
        long result = firstWrongNumber(input, preamble);

        System.out.println("The first number that does not follows the rule: " + result);

        RunningTime.check();
    }

    private static long firstWrongNumber(long[] input, int preamble) {
        long result = -1;
        int checkableNumberIndex = preamble;

        while (checkableNumberIndex < input.length && result == -1) {
            int intervalLowerEnd = checkableNumberIndex - preamble;
            int intervalUpperEnd = checkableNumberIndex - 1;

            boolean foundPair = false;
            for (int i = intervalLowerEnd; i < intervalUpperEnd - 1 && !foundPair; i++) {
                for (int j = i + 1; j < intervalUpperEnd && !foundPair; j++) {
                    if (input[i] != input[j] && (input[i] + input[j]) == input[checkableNumberIndex]) {
                        foundPair = true;
                    }
                }
            }

            result = !foundPair ? input[checkableNumberIndex] : -1;
            checkableNumberIndex++;
        }

        return result;
    }
}