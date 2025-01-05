package rocks.alexmihai.medium.longestpalindrome;

/**
 * - Iterate each character
 * - Each character can be:
 *   - the exact middle character of a palindrome of odd length
 *   - the left character of the middle pair of a palindrome of even length
 * - So for each character and each of the 2 situations, work outwards to find the max palindrome
 */
public class Solution {
    public String longestPalindrome(String s) {
        int maxL = 0, maxR = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int r, l;

            // test exact middle char (odds)
            if (i > 0 && s.charAt(i + 1) == s.charAt(i - 1)) {
                l = i - 1;
                r = i + 1;

                while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--; r++;
                }

                if (r - l > maxR - maxL) {
                    maxR = r;
                    maxL = l;
                }
            }

            // test left char of middle pair (evens)
            if (s.charAt(i + 1) == s.charAt(i)) {
                l = i;
                r = i + 1;

                while (l > 0 && r < s.length() - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                    l--; r++;
                }

                if (r - l > maxR - maxL) {
                    maxR = r;
                    maxL = l;
                }
            }
        }

        return s.substring(maxL, maxR + 1);
    }
}
