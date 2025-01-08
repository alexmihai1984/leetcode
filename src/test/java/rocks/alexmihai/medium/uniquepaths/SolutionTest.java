package rocks.alexmihai.medium.uniquepaths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testUniquePathsSingleCell() {
        var res = solution.uniquePaths(1, 1);

        assertEquals(1, res);
    }

    @Test
    void testUniquePaths3By2() {
        var res = solution.uniquePaths(3, 2);

        assertEquals(3, res);
    }

    @Test
    void testUniquePaths3By7() {
        var res = solution.uniquePaths(3, 7);

        assertEquals(28, res);
    }
}