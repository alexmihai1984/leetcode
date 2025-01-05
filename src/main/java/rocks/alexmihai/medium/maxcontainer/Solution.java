package rocks.alexmihai.medium.maxcontainer;

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
