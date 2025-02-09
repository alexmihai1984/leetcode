package rocks.alexmihai.medium.a4sum;

import java.util.*;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return List.of();

        Arrays.sort(nums);

        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        var leftVal = nums[left];
                        var rightVal = nums[right];
                        while (left < nums.length && nums[left] == leftVal) left++;
                        while (right > j && nums[right] == rightVal) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
