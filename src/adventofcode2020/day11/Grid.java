package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;

class Grid {
    int height;
    int width;
    List<Field> fields = new ArrayList<>();

    public static Grid simulate(Grid grid, List<TwoParameterFunction<Grid, Field, Field>> rules) {
        Grid nextGrid = new Grid(grid.toString().split("\n"));

        for (Field field : grid.fields) {
            Field newField = new Field(field.getX(), field.getY(), field.getType());
            newField.setOccupied(field.isOccupied());
            for (TwoParameterFunction<Grid, Field, Field> rule : rules) {
                Field f = rule.apply(grid, field);
                newField = f == null ? newField : f;
            }
            nextGrid.setField(newField);
        }

        return nextGrid;
    }

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
                    fields.add(new Field(i, height, FieldType.SEAT));
                    break;
                case '.':
                default:
                    fields.add(new Field(i, height, FieldType.FLOOR));
                    break;
            }
        }
        height++;
    }

    public Field getField(int i, int j) {
        if (i >= 0 && j >= 0 && i < width && j < height) {
            return this.fields.get(j * width + i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int seatsOccupied() {
        int count = 0;
        for (Field f : fields) {
            count += f.getType().equals(FieldType.SEAT) && f.isOccupied() ? 1 : 0;
        }

        return count;
    }

    public int adjacentOccupied(Field f) {
        int count = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Field checkableField = getField(f.getX() + i, f.getY() + j);

                    count += checkableField.getType().equals(FieldType.SEAT) && checkableField.isOccupied() ? 1 : 0;
                } catch (IndexOutOfBoundsException e) {
                    // There is no item on that index
                }
            }
        }

        return count;
    }

    public int visibleOccupied(Field f) {
        int count = 0;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Field checkableField = firstVisibleSeat(f, i, j);

                    count += checkableField.getType().equals(FieldType.SEAT) && checkableField.isOccupied() ? 1 : 0;
                } catch (IndexOutOfBoundsException e) {
                    // There is no item on that index
                }
            }
        }

        return count;
    }

    private Field firstVisibleSeat(Field f, int dirX, int dirY) {
        Field firstVisible = null;

        int x = dirX;
        int y = dirY;
        while (firstVisible == null
                && (f.getX() + x >= 0 && f.getY() + y >= 0 && f.getX() + x < width && f.getY() + y < height)) {

            try {
                firstVisible = getField(f.getX() + x, f.getY() + y);
                if (!firstVisible.getType().equals(FieldType.SEAT)) {
                    firstVisible = null;
                }
            } catch (Exception e) {
                // There is no seat on there
            }
            x += dirX;
            y += dirY;
        }

        if (firstVisible == null) {
            throw new IndexOutOfBoundsException();
        }
        return firstVisible;
    }

    private void setField(Field nextField) {
        fields.set(nextField.y * width + nextField.x, nextField);
    }

    public boolean equalsToString(String grid) {
        return this.toString().equals(grid);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
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
            s.append(f.toString());
            w++;
            if (w % width == 0) {
                s.append("\n");
            }
        }

        return s.toString();
    }
}