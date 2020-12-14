package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day11First {

    static final List<Consumer<Grid>> rules = new ArrayList<>() {
        {
            add((Grid g) -> System.out.println("Hali from"));
        }
    };

    public static void main(String[] args) {
        RunningTime.start();

        String[] inputPath = { "day11", "sampleInput.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Grid grid = new Grid();
        for (String line : lines) {
            grid.addLine(line);
        }

        Grid nextGrid = null;

        while (!grid.equals(nextGrid)) {
            nextGrid = Grid.simulate(grid, rules);
            System.out.println(nextGrid.toString());
        }

        RunningTime.check();
    }
}