package src.adventofcode2020.day9;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day9Second {

    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day9", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);
        long[] input = lines.stream().mapToLong(Long::parseLong).toArray();

        int preamble = 25;
        long wrongNumber = firstWrongNumber(input, preamble);

        long weekness = findWeekness(input, wrongNumber);

        System.out.println("The first number that does not follows the rule: " + wrongNumber);
        System.out.println("The encryption weekness is: " + weekness);

        RunningTime.check();
    }

    private static long findWeekness(long[] input, long wrongNumber) {
        long weekness = -1;

        for (int i = 0; i < input.length - 1 && weekness < 0; i++) {
            for (int j = i + 1; j < input.length && weekness < 0; j++) {
                long sum = IntStream.range(i, j + 1).mapToLong(index -> input[index]).sum();
                if (sum == wrongNumber) {
                    LongStream intervalStream = IntStream.range(i, j + 1).mapToLong(index -> input[index]);
                    long min = intervalStream.min().getAsLong();

                    intervalStream = IntStream.range(i, j + 1).mapToLong(index -> input[index]);
                    long max = intervalStream.max().getAsLong();
                    weekness = min + max;
                }
            }
        }

        return weekness;
    }

    private static long firstWrongNumber(long[] input, int preamble) {
        long result = -1;
        int checkableNumberIndex = preamble;

        while (checkableNumberIndex < input.length && result == -1) {
            int intervalLowerEnd = checkableNumberIndex - preamble;
            int intervalUpperEnd = checkableNumberIndex - 1;

            boolean foundPair = false;
            for (int i = intervalLowerEnd; i < intervalUpperEnd && !foundPair; i++) {
                for (int j = i + 1; j <= intervalUpperEnd && !foundPair; j++) {
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