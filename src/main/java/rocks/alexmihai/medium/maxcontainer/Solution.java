package rocks.alexmihai.medium.maxcontainer;

/**
 * - Start from extreme left and right.
 * - Keep track of max volume so far.
 * - Keep the highest edge of the 2 (L, R) and come closer on the other side.
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxVol = 0;

        while (l < r) {
            var vol = Math.min(height[l], height[r]) * (r - l);

            if (vol > maxVol) {
                maxVol = vol;
            }

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxVol;
    }
}
