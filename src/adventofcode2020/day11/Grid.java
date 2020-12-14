package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Grid {
    int height;
    int width;
    List<Field> fields = new ArrayList<>();

    public Grid() {
    }

    public Grid(String[] lines) {
        for (String line : lines) {
            addLine(line);
        }
    }

    public void addLine(String line) {
        width = line.length();
        for (int i = 0; i < line.length(); i++) {
            char field = line.charAt(i);
            switch (field) {
                case 'L':
                    fields.add(new Field(height * i, i, FieldType.SEAT));
                    break;
                case '.':
                default:
                    fields.add(new Field(height * i, i, FieldType.FLOOR));
                    break;
            }
        }
        height++;
    }

    public Field getField(int i, int j) {
        return this.fields.get(i * height + j);
    }

    public static Grid simulate(Grid grid, List<Consumer<Grid>> rules) {
        Grid nextGrid = new Grid(grid.toString().split("\n"));

        rules.get(0).accept(grid);

        return nextGrid;
    }

    public boolean equalsToString(String grid) {
        return this.toString().equals(grid);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof Grid) {
            String objString = ((Grid) obj).toString();
            String thisString = this.toString();

            return objString.equals(thisString);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        int w = 0;
        StringBuilder s = new StringBuilder();
        for (Field f : fields) {
            s.append(f.getType() == FieldType.FLOOR ? "." : (f.isOccupied() ? "#" : "L"));
            w++;
            if (w % width == 0) {
                s.append("\n");
            }
        }

        return s.toString();
    }
}