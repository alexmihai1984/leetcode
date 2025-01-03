package rocks.alexmihai.medium.arrayduplicates;

import java.util.ArrayList;
import java.util.List;

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
