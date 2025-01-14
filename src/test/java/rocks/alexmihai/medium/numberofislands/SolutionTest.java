package rocks.alexmihai.medium.numberofislands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testNumIslandsOne() {
        var grid = new char[][]{
                {'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        var res = solution.numIslands(grid);

        assertEquals(1, res);
    }

    @Test
    void testNumIslandsThree() {
        var grid = new char[][]{
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        var res = solution.numIslands(grid);

        assertEquals(4, res);
    }
}