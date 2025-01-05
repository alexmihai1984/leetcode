package rocks.alexmihai.medium.longestpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void testLongestPalindromeSingleLetter() {
        var res = solution.longestPalindrome("a");

        assertEquals("a", res);
    }

    @Test
    void testLongestPalindromeTwoLetters() {
        var res = solution.longestPalindrome("aa");

        assertEquals("aa", res);
    }

    @Test
    void testLongestPalindromeThreeLetters() {
        var res = solution.longestPalindrome("aaa");

        assertEquals("aaa", res);
    }

    @Test
    void testLongestPalindromeFourLetters() {
        var res = solution.longestPalindrome("aaaa");

        assertEquals("aaaa", res);
    }

    @Test
    void testLongestPalindromeUniqueLetters() {
        var res = solution.longestPalindrome("abcd");

        assertEquals("a", res);
    }

    @Test
    void testLongestPalindromeTwoLettersResult() {
        var res = solution.longestPalindrome("cbbd");

        assertEquals("bb", res);
    }

    @Test
    void testLongestPalindromeThreeLettersResult() {
        var res = solution.longestPalindrome("babad");

        assertEquals("bab", res);
    }

    @Test
    void testLongestPalindromeOverlapping() {
        var res = solution.longestPalindrome("12233222233222233");

        assertEquals("33222233222233", res);
    }
}