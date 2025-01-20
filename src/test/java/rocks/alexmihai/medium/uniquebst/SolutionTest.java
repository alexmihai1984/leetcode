package rocks.alexmihai.medium.uniquebst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testGenerateTreesOne() {
        var res = solution.generateTrees(1);

        assertEquals(1, res.size());
        assertEquals(1, res.getFirst().val);
        assertNull(res.getFirst().left);
        assertNull(res.getFirst().right);
    }

    @Test
    void testGenerateTreesThree() {
        var res = solution.generateTrees(3);

        assertEquals(5, res.size());
    }
}