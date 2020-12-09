package src.adventofcode2020.day8;

import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day8Second {
    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day8", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        HandheldConsole console = new HandheldConsole(lines);
        console.tryToFix = true;

        console.start();

        RunningTime.check();
    }
}