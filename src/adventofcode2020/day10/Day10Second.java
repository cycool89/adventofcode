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
        int[] input = lines.stream().mapToInt(Integer::parseInt).toArray();

        RunningTime.check();
    }
}