package src.adventofcode2020.day6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.lib.FileHandler;

public class Day6Second {

    public static void main(String[] args) {
        String[] inputPath = { "day6", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Map<Character, Integer> uniqueAnswers = new HashMap<>();
        int groupMemberCount = 0;
        int groupAnswerCount = 0;

        for (String line : lines) {
            if (line.isEmpty()) {
                for (Map.Entry<Character, Integer> answerCount : uniqueAnswers.entrySet()) {
                    if (answerCount.getValue().equals(groupMemberCount)) {
                        groupAnswerCount++;
                    }
                }

                uniqueAnswers = new HashMap<>();
                groupMemberCount = 0;
            } else {
                groupMemberCount++;
                for (int i = 0; i < line.length(); i++) {
                    if (uniqueAnswers.get(line.charAt(i)) == null) {
                        uniqueAnswers.put(line.charAt(i), 0);
                    }
                    uniqueAnswers.put(line.charAt(i), uniqueAnswers.get(line.charAt(i)) + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> answerCount : uniqueAnswers.entrySet()) {
            if (answerCount.getValue().equals(groupMemberCount)) {
                groupAnswerCount++;
            }
        }

        System.out.println("Sum of answers: " + groupAnswerCount);

    }
}