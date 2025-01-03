package rocks.alexmihai.medium.arrayduplicates;

import java.util.ArrayList;
import java.util.List;

/**
 * - Iterate array
 * - If a particular value is negative, it means the value `index + 1` has been seen before and this is the second occurrence
 * - Look at `nums[value - 1]`
 *   - If it's negative, add `value` to results
 *   - If it's positive, turn it negative, meaning `value` has been seen
 */
public class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        var res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            var val = Math.abs(nums[i]);
            var idx = val - 1;
            if (nums[idx] < 0) {
                res.add(val);
            } else {
                nums[idx] = -nums[idx];
            }
        }

        return res;
    }
}
