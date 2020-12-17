package src.adventofcode2020.day12;

class Ship {
    int x = 0;
    int y = 0;
    int r = 90; // EAST
    Direction forwardDirection = Direction.E;

    public void move(Direction direction, int unit) {
        switch (direction) {
            case N:
                y += unit;
                break;
            case S:
                y -= unit;
                break;
            case E:
                x += unit;
                break;
            case W:
                x -= unit;
                break;
            case L:
                r -= unit;
                updateForwardDirection();
                break;
            case R:
                r += unit;
                updateForwardDirection();
                break;
            case F:
                move(forwardDirection, unit);
                break;
        }

    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    private void updateForwardDirection() {
        int degToDir = r / 90;
        int modulus = (((degToDir % 4) + 4) % 4);
        switch (modulus) {
            case 0:
                forwardDirection = Direction.N;
                break;
            case 1:
                forwardDirection = Direction.E;
                break;
            case 2:
                forwardDirection = Direction.S;
                break;
            case 3:
            default:
                forwardDirection = Direction.W;
                break;
        }
    }
}