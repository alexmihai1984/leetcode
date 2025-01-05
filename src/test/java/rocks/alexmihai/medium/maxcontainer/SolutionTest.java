package rocks.alexmihai.medium.maxcontainer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testMaxAreaTrivial() {
        var res = solution.maxArea(new int[]{1, 1});

        assertEquals(1, res);
    }

    @Test
    void testMaxAreaMoreTricky() {
        var res = solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7});

        assertEquals(49, res);
    }

    @Test
    void testMaxAreaAdjacent() {
        var res = solution.maxArea(new int[]{1,3,2,5,25,24,5});

        assertEquals(24, res);
    }
}