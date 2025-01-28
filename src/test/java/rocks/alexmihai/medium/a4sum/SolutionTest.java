package rocks.alexmihai.medium.a4sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testFourSumArrayTooSmall() {
        var res = solution.fourSum(new int[]{1, 2, 3}, 5);

        assertTrue(res.isEmpty());
    }

    @Test
    void testFourSumSimple() {
        var res = solution.fourSum(new int[]{1, -1, 0, -2, 2}, 0);

        assertEquals(1, res.size());
    }

    @Test
    void testFourSumRepeatingItem() {
        var res = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        assertEquals(3, res.size());
    }

    @Test
    void testFourSumAllRepeating() {
        var res = solution.fourSum(new int[]{2, 2, 2, 2, 2}, 8);

        assertEquals(1, res.size());
    }

    @Test
    void testFourSumDuplicateWays() {
        var res = solution.fourSum(new int[]{-5, 5, 4, -3, 0, 0, 4, -2}, 4);

        assertEquals(2, res.size());
    }

    @Test
    void testFourSumComplicated() {
        var res = solution.fourSum(new int[]{0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7}, 6);

        assertEquals(8, res.size());
    }
}