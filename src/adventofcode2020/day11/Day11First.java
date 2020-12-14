package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day11First {

    static final List<TwoParameterFunction<Grid, Field, Field>> rules = new ArrayList<>();

    public static void main(String[] args) {
        RunningTime.start();

        setRules();

        String[] inputPath = { "day11", "sampleInput.txt" };
        List<String> lines = FileHandler.readByLine(2020, inputPath);

        Grid grid = new Grid();
        for (String line : lines) {
            grid.addLine(line);
        }

        Grid nextGrid = null;
        Grid prevGrid = null;

        do {
            prevGrid = nextGrid == null ? grid : nextGrid;
            nextGrid = Grid.simulate(prevGrid, rules);
            System.out.println("---------------------");
            System.out.println(prevGrid.toString());
            System.out.println("---------------------");
            System.out.println(nextGrid.toString());
            System.out.println("---------------------");
        } while (!prevGrid.equals(nextGrid));

        RunningTime.check();
    }

    private static void setRules() {
        rules.add((Grid g, Field f) -> {
            return new Field(f.getX(), f.getY(), FieldType.FLOOR);
        });
    }
}