package rocks.alexmihai.medium.firstlastinsorted;

/**
 * - Binary search any occurrence of the target value.
 * - Go left until something else is found.
 * - Go right until something else is found.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        var res = new int[]{-1,-1};

        if (nums.length == 0) {
            return res;
        }

        int idx = binarySearch(nums, 0, nums.length - 1, target);
        if (idx < 0) {
            return res;
        }

        int l = idx;
        while ((l - 1 >= 0) && (nums[l - 1] == target)) {
            l--;
        }

        int r = idx;
        while ((r + 1 < nums.length) && (nums[r + 1] == target)) {
            r++;
        }

        res[0] = l;
        res[1] = r;

        return res;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (end - start <= 1) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            return -1;
        }

        int mid = (end - start) / 2 + start;

        if (nums[mid] > target) {
            return binarySearch(nums, start, mid, target);
        } else if (nums[mid] < target) {
             return binarySearch(nums, mid, end, target);
        } else {
            return mid;
        }
    }
}
