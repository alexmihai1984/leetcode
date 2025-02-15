package rocks.alexmihai.medium.firstlastinsorted;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution2Test {

    Solution2 solution = new Solution2();

    @Test
    void testSearchRangeEmpty() {
        var res = solution.searchRange(new int[]{}, 0);

        assertArrayEquals(new int[]{-1, -1}, res);
    }

    @Test
    void testSearchRangeSingleEntryFound() {
        var res = solution.searchRange(new int[]{1}, 1);

        assertArrayEquals(new int[]{0, 0}, res);
    }

    @Test
    void testSearchRangeSingleEntryNotFound() {
        var res = solution.searchRange(new int[]{1}, 2);

        assertArrayEquals(new int[]{-1, -1}, res);
    }

    @Test
    void testSearchRangeFound() {
        var res = solution.searchRange(new int[]{5,7,7,8,8,10}, 8);

        assertArrayEquals(new int[]{3, 4}, res);
    }

    @Test
    void testSearchRangeNotFound() {
        var res = solution.searchRange(new int[]{5,7,7,8,8,10}, 6);

        assertArrayEquals(new int[]{-1, -1}, res);
    }

    @Test
    void testSearchLongRepeatingOdd() {
        var res = solution.searchRange(new int[]{11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,13}, 12);

        assertArrayEquals(new int[]{1, 25}, res);
    }

    @Test
    void testSearchLongRepeatingEven() {
        var res = solution.searchRange(new int[]{11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,13}, 12);

        assertArrayEquals(new int[]{1, 24}, res);
    }

    @Test
    void testSearchTwoItemsFound() {
        var res = solution.searchRange(new int[]{2,2}, 2);

        assertArrayEquals(new int[]{0, 1}, res);
    }
}