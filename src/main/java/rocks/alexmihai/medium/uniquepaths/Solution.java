package rocks.alexmihai.medium.uniquepaths;

/**
 * - If there's a cell to the right, recursively compute number of paths from the right cell.
 * - If there's a cell below, recursively compute number of paths from the cell below.
 * - Add the 2 numbers above, that's the number of paths from the current cell.
 * - Keep cache of computation for each cell, because you can get to a cell multiple ways.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];

        return uniquePathsFrom(0, 0, cache);
    }

    private int uniquePathsFrom(int i, int j, int[][] cache) {
        if (i == cache.length - 1 && j == cache[0].length - 1) return 1;

        if (cache[i][j] > 0) return cache[i][j];

        var res = 0;
        if (i < cache.length - 1) {
            res += uniquePathsFrom(i + 1, j, cache);
        }

        if (j < cache[0].length - 1) {
            res += uniquePathsFrom(i, j + 1, cache);
        }

        cache[i][j] = res;

        return res;
    }
}
