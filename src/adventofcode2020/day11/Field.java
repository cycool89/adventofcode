package src.adventofcode2020.day11;

class Field {
    int x;
    int y;
    boolean occupied = false;
    final FieldType type;

    public Field(int x, int y, FieldType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public FieldType getType() {
        return this.type;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return getType() == FieldType.FLOOR ? "." : (isOccupied() ? "#" : "L");
    }
}