package rocks.alexmihai.medium.bitwiseandrange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testRangeBitwiseAndZeroes() {
        var res = solution.rangeBitwiseAnd(0, 0);

        assertEquals(0, res);
    }

    @Test
    void testRangeBitwiseAndSmall() {
        var res = solution.rangeBitwiseAnd(5, 7);

        assertEquals(4, res);
    }

    @Test
    void testRangeBitwiseAndHuge() {
        var res = solution.rangeBitwiseAnd(1, 2147483647);

        assertEquals(0, res);
    }

    @Test
    void testRangeBitwiseAndMaxEdge() {
        var res = solution.rangeBitwiseAnd(2147483646, 2147483647);

        assertEquals(2147483646, res);
    }

    @Test
    void testRangeBitwiseAndJustMax() {
        var res = solution.rangeBitwiseAnd(2147483647, 2147483647);

        assertEquals(2147483647, res);
    }

    @Test
    void testRangeBitwiseAndBigRange() {
        var res = solution.rangeBitwiseAnd(1073741824, 2147483647);

        assertEquals(1073741824, res);
    }
}