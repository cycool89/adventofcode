package src.adventofcode2020.day5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import src.lib.FileHandler;

public class Day5Second {

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

    private static int getSeatId(String boardingPass) {
        String rows = boardingPass.substring(0, 7);
        String cols = boardingPass.substring(7);

        int rowIndex = findIndex(rows, MAX_ROW);
        int colIndex = findIndex(cols, MAX_COL);
        return rowIndex * 8 + colIndex;
    }

    public static void main(String[] args) {
        String[] inputPath = { "day5", "input.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        SortedSet<Integer> seatIds = new TreeSet<>();

        for (String line : lines) {
            int seatId = getSeatId(line);

            seatIds.add(seatId);
        }

        Iterator<Integer> iterator = seatIds.iterator();
        int prevSeat = iterator.next();
        int actSeat = iterator.next();
        int nextSeat = iterator.next();

        int mySeat = -1;
        while (iterator.hasNext() && mySeat < 0) {
            if (nextSeat - prevSeat > 2) {
                mySeat = actSeat + 1;
            }

            prevSeat = actSeat;
            actSeat = nextSeat;
            nextSeat = iterator.next();
        }

        System.out.println("My seatIS on the plane is " + mySeat);
    }
}