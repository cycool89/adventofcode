package src.adventofcode2020.day12;

public class InputConverter {
    public static Direction getDirection(String line) {
        return Direction.valueOf(line.substring(0, 1));
    }

    public static int getUnit(String line) {
        return Integer.parseInt(line.substring(1));
    }
}
