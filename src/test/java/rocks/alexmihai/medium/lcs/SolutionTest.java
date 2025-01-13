package rocks.alexmihai.medium.lcs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testLongestCommonSubsequenceNothingCommon() {
        var res = solution.longestCommonSubsequence("abc", "def");

        assertEquals(0, res);
    }

    @Test
    void testLongestCommonSubsequenceIdentical() {
        var res = solution.longestCommonSubsequence("abc", "abc");

        assertEquals(3, res);
    }

    @Test
    void testLongestCommonSubsequenceSkipping() {
        var res = solution.longestCommonSubsequence("abcde", "ace");

        assertEquals(3, res);
    }
}