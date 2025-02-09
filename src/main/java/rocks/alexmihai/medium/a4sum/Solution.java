package rocks.alexmihai.medium.a4sum;

import java.util.*;

public class Solution {
    public static class Quadruplet {
        private final int first;
        private final int second;
        private final int third;
        private final int fourth;

        public Quadruplet(int first, int second, int third, int fourth) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
        }

        @Override
        public int hashCode() {
            return first + second + third + fourth;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Quadruplet otherQuadruplet)) return false;

            var counts = counts(this);
            var otherCounts = counts(otherQuadruplet);

            return counts.equals(otherCounts);
        }

        private Map<Integer, Integer> counts(Quadruplet quadruplet) {
            var counts = new HashMap<Integer, Integer>(4);
            counts.put(quadruplet.first, 1);

            counts.putIfAbsent(quadruplet.second, 0);
            counts.put(quadruplet.second, counts.get(quadruplet.second) + 1);

            counts.putIfAbsent(quadruplet.third, 0);
            counts.put(quadruplet.third, counts.get(quadruplet.third) + 1);

            counts.putIfAbsent(quadruplet.fourth, 0);
            counts.put(quadruplet.fourth, counts.get(quadruplet.fourth) + 1);

            return counts;
        }
    }

    public List<List<Integer>> fourSumOld(int[] nums, int target) {
        if (nums.length < 4) return List.of();

        var set = new HashSet<Quadruplet>();

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            set.add(new Quadruplet(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        var res = new ArrayList<List<Integer>>();
        for (var quadruplet : set) {
            res.add(List.of(quadruplet.first, quadruplet.second, quadruplet.third, quadruplet.fourth));
        }

        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return List.of();

        Arrays.sort(nums);

        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1])continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(j>i+1 && nums[j]==nums[j-1] )continue;
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    System.out.println("Looking at: " + nums[i] + "," + nums[j] + "," + nums[left] + "," + nums[right]);
                    System.out.println("Indices: " + i + "," + j + "," + left + "," + right);
//                    var leftVal = nums[left];
//                    var rightVal = nums[right];

                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        var leftVal = nums[left];
                        var rightVal = nums[right];
                        while (left < nums.length && nums[left] == leftVal) left++;
                        while (right > j && nums[right] == rightVal) right--;

//                        while (left < right && nums[left] == leftVal) left++;
//                        while (left < right && nums[right] == rightVal) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }


//                    var leftVal = nums[left];
//                    var rightVal = nums[right];
//                    while (nums[left] == leftVal && left < nums.length) left++;
//                    while (nums[right] == rightVal && right > j) right--;
                }
            }
        }

        return res;
    }
}
