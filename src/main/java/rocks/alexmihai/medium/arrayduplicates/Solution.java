package rocks.alexmihai.medium.arrayduplicates;

import java.util.ArrayList;
import java.util.List;

/**
 * - Use some non-positive values to mark state:
 *  - 0 - value deleted, so as not to be picked up again
 *  - -1 - value `index + 1` has been seen before
 * - Iterate elements and select the first index with positive value (first element the first time)
 * - Set the value to 0, so as not to be picked up again
 * - If the value at index `value - 1` is -1, add `value` to results
 * - Set the value at index `value - 1` to -1
 * - Use the previously existing value at index `value - 1` as the next value, else it will be lost; but if it's a
 *   non-positive value, pick the next positive one from the array
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;

            var val = nums[i];
            nums[i] = 0;
            while (val > 0) {
                var idx = val - 1;

                if (nums[idx] == -1) {
                    res.add(val);
                }

                if (nums[idx] <= 0) {
                    nums[idx] = -1;
                    break;
                }

                val = nums[idx];
                nums[idx] = -1;
            }
        }

        return res;
    }
}
