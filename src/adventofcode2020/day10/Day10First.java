package src.adventofcode2020.day10;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day10First {
    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day10", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);
        int[] input = lines.stream().mapToInt(Integer::parseInt).toArray();

        AtomicInteger outlet = new AtomicInteger(0);
        AtomicInteger diff1Count = new AtomicInteger(0);
        AtomicInteger diff3Count = new AtomicInteger(1);

        Arrays.stream(input).sorted().forEach(adapter -> {
            if (adapter - outlet.get() == 1)
                diff1Count.incrementAndGet();
            if (adapter - outlet.get() == 3)
                diff3Count.incrementAndGet();

            outlet.set(adapter);
        });

        System.out.println("1-jolt differences multiplied by the number of 3-jolt differences: "
                + (diff1Count.get() * diff3Count.get()));

        RunningTime.check();
    }
}