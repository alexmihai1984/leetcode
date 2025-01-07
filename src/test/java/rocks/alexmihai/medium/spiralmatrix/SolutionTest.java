package rocks.alexmihai.medium.spiralmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testGenerateMatrix1() {
        var res = solution.generateMatrix(1);

        assertEquals(1, res.length);
        assertArrayEquals(new int[]{1}, res[0]);
    }

    @Test
    void testGenerateMatrix3() {
        var res = solution.generateMatrix(3);

        assertEquals(3, res.length);
        assertArrayEquals(new int[]{1, 2, 3}, res[0]);
        assertArrayEquals(new int[]{8, 9, 4}, res[1]);
        assertArrayEquals(new int[]{7, 6, 5}, res[2]);
    }
}