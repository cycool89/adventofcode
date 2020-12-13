package src.adventofcode2020.day11;

class Field {
    boolean occupied = false;
    final FieldType type;

    public Field(FieldType type) {
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
}