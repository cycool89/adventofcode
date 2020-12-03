package src.adventofcode2015.day1;

import java.util.List;

import src.lib.FileHandler;

public class Day1First {
    public static void main(String[] args) {
        String[] inputPath = { "day1", "input.txt" };
        List<String> lines = FileHandler.readByLine(2015, inputPath);
        String line = lines.get(0);

        long up = line.chars().filter(ch -> ch == '(').count();
        long down = line.chars().filter(ch -> ch == ')').count();

        long result = up - down;

        System.out.println("Santa will be on floor " + result);

    }
}