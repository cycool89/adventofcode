package src.adventofcode2020.day11;

import java.util.ArrayList;
import java.util.List;

class Grid {
    int height;
    int width;
    List<Field> fields = new ArrayList<>();

    public void addLine(String line) {
        height++;
        width = line.length();
        for (int i = 0; i < line.length(); i++) {
            char field = line.charAt(i);
            switch (field) {
                case 'L':
                    fields.add(new Field(FieldType.SEAT));
                    break;
                case '.':
                default:
                    fields.add(new Field(FieldType.FLOOR));
                    break;
            }
        }
    }

    public void simulate() {
        String prevGrid = null;
        while (!this.equalsToString(prevGrid)) {
            prevGrid = this.toString();
        }
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