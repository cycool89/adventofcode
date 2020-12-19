package src.adventofcode2020.day12;

class Ship {
    int x = 0;
    int y = 0;
    int r = 90; // EAST
    Direction forwardDirection = Direction.E;

    int wx = 10;
    int wy = 1;

    public void doEvasiveActionForPartOne(Direction direction, int unit) {
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
                doEvasiveActionForPartOne(forwardDirection, unit);
                break;
        }
    }

    public void doEvasiveActionForPartTwo(Direction direction, int unit) {
        switch (direction) {
            case N:
                wy += unit;
                break;
            case S:
                wy -= unit;
                break;
            case E:
                wx += unit;
                break;
            case W:
                wx -= unit;
                break;
            case L:
                rotateWaypoint(direction, unit);
                break;
            case R:
                rotateWaypoint(direction, unit);
                break;
            case F:
                x += unit * wx;
                y += unit * wy;
                break;
        }
    }

    public int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    private void rotateWaypoint(Direction direction, int unit) {
        int degToDir = unit / 90;
        if (direction == Direction.L) {
            degToDir = -degToDir;
        }
        int modulus = (((degToDir % 4) + 4) % 4);

        for (int i = 0; i < modulus; i++) {
            int temp = wx;
            wx = wy;
            wy = -temp;
        }
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