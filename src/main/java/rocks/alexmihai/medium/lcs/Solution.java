package rocks.alexmihai.medium.lcs;

import java.util.Arrays;

/**
 * Recursive solution.
 * - Check first char of each array
 * - If they are equal, the result is the LCS of the 2 substrings excluding the first chars.
 * - If they are not equal, the result is the max of (the LCS of the full text1 and the substring of text2 excluding
 * the first char) and (the LCS of the full text2 and the substring of text1 excluding the first char)
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);

        return lcs(text1, text2, 0, 0, dp);
    }

    private int lcs(String text1, String text2, int idx1, int idx2, int[][] dp) {
        if (idx1 >= text1.length() || idx2 >= text2.length()) return 0;

        if (dp[idx1][idx2] >= 0) return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            dp[idx1][idx2] = 1 + lcs(text1, text2, idx1 + 1, idx2 + 1, dp);
        } else {
            dp[idx1][idx2] = Math.max(
                    lcs(text1, text2, idx1 + 1, idx2, dp),
                    lcs(text1, text2, idx1, idx2 + 1, dp)
            );
        }

        return dp[idx1][idx2];
    }
}
