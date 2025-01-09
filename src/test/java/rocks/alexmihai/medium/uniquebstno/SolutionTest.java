package rocks.alexmihai.medium.uniquebstno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testNumTreesOne() {
        var res = solution.numTrees(1);

        assertEquals(0, res);
    }

    @Test
    void testNumTreesThree() {
        var res = solution.numTrees(3);

        assertEquals(5, res);
    }

    @Test
    void testNumTreesFive() {
        var res = solution.numTrees(5);

        assertEquals(42, res);
    }
}