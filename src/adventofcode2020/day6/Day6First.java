package src.adventofcode2020.day6;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import src.lib.FileHandler;

public class Day6First {

    public static void main(String[] args) {
        String[] inputPath = { "day6", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Set<Character> uniqueAnswers = new TreeSet<>();
        int groupAnswerCounts = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                groupAnswerCounts += uniqueAnswers.size();

                uniqueAnswers = new TreeSet<>();
            } else {
                for (int i = 0; i < line.length(); i++) {
                    uniqueAnswers.add(line.charAt(i));
                }
            }
        }
        groupAnswerCounts += uniqueAnswers.size();

        System.out.println("Sum of ansers: " + groupAnswerCounts);

    }
}