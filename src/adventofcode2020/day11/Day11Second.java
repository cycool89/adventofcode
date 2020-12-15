package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;

import src.lib.FileHandler;
import src.lib.RunningTime;

public class Day11Second {
    static final List<TwoParameterFunction<Grid, Field, Field>> rules = new ArrayList<>();

    public static void main(String[] args) {
        RunningTime.start();

        setRules();

        String[] inputPath = { "day11", "input.txt" };
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
        } while (!prevGrid.equals(nextGrid));

        System.out.println("There are " + prevGrid.seatsOccupied() + " occupied seats.");

        RunningTime.check();
    }

    private static void setRules() {
        rules.add((Grid g, Field f) -> {
            Field newField = new Field(f.getX(), f.getY(), f.getType());
            switch (f.getType()) {
                case SEAT:
                    if (!f.isOccupied() && g.visibleOccupied(f) == 0) {
                        newField.setOccupied(true);
                    } else {
                        return null;
                    }
                    return newField;
                case FLOOR:
                default:
                    return null;
            }
        });

        rules.add((Grid g, Field f) -> {
            Field newField = new Field(f.getX(), f.getY(), f.getType());
            switch (f.getType()) {
                case SEAT:
                    if (f.isOccupied() && g.visibleOccupied(f) >= 5) {
                        newField.setOccupied(false);
                    } else {
                        return null;
                    }
                    return newField;
                case FLOOR:
                default:
                    return null;
            }
        });
    }
}