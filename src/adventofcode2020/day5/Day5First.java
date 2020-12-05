package src.adventofcode2020.day5;

import java.util.List;

import src.lib.FileHandler;

public class Day5First {

    static final int MAX_ROW = 127;
    static final int MAX_COL = 7;

    private static int findIndex(String instructions, int maxValue) {
        int instructionIndex = 0;
        int lowerEnd = 0;
        int upperEnd = maxValue;

        while (lowerEnd != upperEnd && instructionIndex < instructions.length()) {
            int index = (lowerEnd + upperEnd) / 2;
            char instruction = instructions.charAt(instructionIndex);

            switch (instruction) {
                case 'F':
                case 'L':
                    upperEnd = index;
                    break;
                case 'B':
                case 'R':
                default:
                    lowerEnd = index + 1;
                    break;
            }

            instructionIndex++;
        }

        return lowerEnd;
    }

    public static void main(String[] args) {
        String[] inputPath = { "day5", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        int maxSeatId = 0;

        for (String line : lines) {
            String rows = line.substring(0, 7);
            String cols = line.substring(7);

            int rowIndex = findIndex(rows, MAX_ROW);
            int colIndex = findIndex(cols, MAX_COL);

            int seatId = rowIndex * 8 + colIndex;

            if (seatId > maxSeatId) maxSeatId = seatId;
        }

        System.out.println("Highest seatId on the boarding passes: " + maxSeatId);

    }
}