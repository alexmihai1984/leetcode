package rocks.alexmihai.medium.uniquebstno;

/**
 * Lets thing of the tree at the root.
 * - Any element can be the root
 * - Given a chosen root element, the number of unique trees is = (the number of unique ways we can arrange the elements
 *   less than it in the left subtree) * (the number of unique ways we can arrange the elements greater than it in the
 *   right subtree)
 * General observations:
 * - Only the number of elements is relevant, not the identity, elements (1, 2, 3) and (4, 5, 6) can be arranged in
 *   the same number of ways
 * So in a general sense, the number of ways a subtree can be arranged is determined by summing for all possible roots
 * (the number of ways the left elements can be arranged) * (the number of ways the right elements can be arranged).
 * This is the recursion.
 * The base case is that a subtree of size 0 or 1 can be arranged in just 1 way.
 * Cache the calculations, as they are needed multiple times.
 */
public class Solution {
    public int numTrees(int n) {
        var cache = new int[n + 1];

        return countSubtree(n, cache);
    }

    private int countSubtree(int elementsNo, int[] cache) {
        if (elementsNo <= 1) return 1;

        if (cache[elementsNo] != 0) return cache[elementsNo];

        var res = 0;
        for (int i = 1; i <= elementsNo; i++) {
            res += countSubtree(i - 1, cache) * countSubtree(elementsNo - i, cache);
        }

        cache[elementsNo] = res;

        return res;
    }
}
