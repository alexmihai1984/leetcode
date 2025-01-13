package rocks.alexmihai.medium.deleteop2strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testMinDistancePartial() {
        var res = solution.minDistance("sea", "eat");

        assertEquals(2, res);
    }

    @Test
    void testMinDistanceOneFullWord() {
        var res = solution.minDistance("leetcode", "etco");

        assertEquals(4, res);
    }
}