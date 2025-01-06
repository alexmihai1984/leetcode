package rocks.alexmihai.medium.firstlastinsorted;

/**
 * - If first element = target, that is L. If not, binary search for a pair (x, target), that is L.
 * - If last element = target, that is R. If not, binary search for a pair (target, x), that is R.
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        var res = new int[]{-1,-1};

        if (nums.length == 0) {
            return res;
        }

        if (nums[0] == target) {
            res[0] = 0;
        } else {
            res[0] = binarySearchL(nums, target, 0, nums.length - 1);
        }

        if (nums[nums.length - 1] == target) {
            res[1] = nums.length - 1;
        } else {
            res[1] = binarySearchR(nums, target, 0, nums.length - 1);
        }

        return res;
    }

    private int binarySearchL(int[] nums, int target, int start, int end) {
        if (end - start == 0) return -1;
        if (end - start == 1) {
            if (nums[start] < target && nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }

        int midR = (end - start) / 2 + start;
        int midL = midR - 1;

        if (nums[midR] == target) {
            if (midL < 0 || nums[midL] < target) {
                return midR;
            } else {
                return binarySearchL(nums, target, start, midL);
            }
        } else if (nums[midR] > target) {
            return binarySearchL(nums, target, start, midL);
        } else {
            return binarySearchL(nums, target, midR, end);
        }
    }

    private int binarySearchR(int[] nums, int target, int start, int end) {
        if (end - start == 0) return -1;
        if (end - start == 1) {
            if (nums[start] == target && nums[end] > target) {
                return start;
            } else {
                return -1;
            }
        }

        int midL = (end - start) / 2 + start;
        int midR = midL + 1;

        if (nums[midL] == target) {
            if (midR >= nums.length || nums[midR] > target) {
                return midL;
            } else {
                return binarySearchR(nums, target, midR, end);
            }
        } else if (nums[midL] > target) {
            return binarySearchR(nums, target, start, midL);
        } else {
            return binarySearchR(nums, target, midR, end);
        }
    }
}
