package rocks.alexmihai.medium.bitwiseandrange;

/**
 * - (n - 1) has the last 1 bit of n turned into 0. Subsequent bits will be 1.
 * - Because of the above, when doing n & (n - 1), you will get n with all zeroes starting with what was previously
 *   the last 1.
 * - So n & (n - 1) is:
 *   - a number < n.
 *   - a number that does not get affected by an & operation with any number greater than itself and less than n.
 * - Based on the above, you can iterate on n = n & (n - 1) and thus skip a bunch of numbers, each time getting
 *   rid of a bit. This way the algo is constant time (32 bits).
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        var res = right;

        while (res > left) {
            res &= res - 1;
        }

        return res;
    }
}
