package rocks.alexmihai.medium.spiralmatrix;

/**
 * Just iterate in the correct order (not that easy) and set the next value.
 */
public class Solution {
    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP,
        DONE
    }

    public int[][] generateMatrix(int n) {
        var res = new int[n][n];

        var direction = Direction.RIGHT;
        int i = 0, j = 0;
        var val = 1;

        do {
            res[i][j] = val;
            val++;

            direction = whereToGo(direction, res, i, j);

            if (direction == Direction.RIGHT) j++;
            else if (direction == Direction.DOWN) i++;
            else if (direction == Direction.LEFT) j--;
            else if (direction == Direction.UP) i--;
        } while (direction != Direction.DONE);

        return res;
    }

    private Direction whereToGo(Direction direction, int[][] res, int i, int j) {
        if (direction == Direction.RIGHT) {
            if (j < res.length - 1 && res[i][j + 1] == 0) return Direction.RIGHT;
            else if (i < res.length - 1 && res[i + 1][j] == 0) return Direction.DOWN;
            else return Direction.DONE;
        }

        if (direction == Direction.DOWN) {
            if (i < res.length - 1 && res[i + 1][j] == 0) return Direction.DOWN;
            else if (j > 0 && res[i][j - 1] == 0) return Direction.LEFT;
            else return Direction.DONE;
        }

        if (direction == Direction.LEFT) {
            if (j > 0 && res[i][j - 1] == 0) return Direction.LEFT;
            else if (i > 0 && res[i - 1][j] == 0) return Direction.UP;
            else return Direction.DONE;
        }

        if (direction == Direction.UP) {
            if (i > 0 && res[i - 1][j] == 0) return Direction.UP;
            else if (j < res.length - 1 && res[i][j + 1] == 0) return Direction.RIGHT;
            else return Direction.DONE;
        }

        return Direction.DONE;
    }
}
