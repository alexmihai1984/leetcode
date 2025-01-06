package rocks.alexmihai.medium.pow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testMyPowInteger() {
        var res = solution.myPow(2, 10);

        assertEquals(1024L, res);
    }

    @Test
    void testMyPowDecimal() {
        var res = solution.myPow(2.1, 3);

        assertEquals(9.261, res, 0.000001);
    }

    @Test
    void testMyPowNegativeExponent() {
        var res = solution.myPow(2, -2);

        assertEquals(0.25, res);
    }

    @Test
    void testMyPowHugeExponent() {
        var res = solution.myPow(1, 2147483647);

        assertEquals(1, res);
    }
}