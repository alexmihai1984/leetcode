package rocks.alexmihai.medium.arrayduplicates;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var res = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;

            var currentValue = nums[i];
            nums[i] = 0;
            while (currentValue > 0) {
                var idx = currentValue - 1;

                if (nums[idx] == -1) {
                    res.add(currentValue);
                    nums[idx] = -2;
                }

                if (idx == i) {
                    nums[idx] = -1;
                    break;
                }

                currentValue = nums[idx];
                nums[idx] = -1;
            }
        }

        return res;
    }
}
