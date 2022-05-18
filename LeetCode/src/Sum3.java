import java.util.*;

public class Sum3 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            int length = nums.length;

            if (length < 3) {
                return list;
            }

            Arrays.sort(nums);

            for (int i = 0; i < length-2 ; i++) {
                if (nums[i] > 0) {
                    break;
                }

                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }

                int left = i + 1;
                int right = length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum == 0) {
                        list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        ++left;
                        --right;

                        while (nums[left] == nums[left-1] && left < right) ++left;
                        while (nums[right] == nums[right+1]  && left < right) --right;
                    } else if (sum > 0) {
                        --right;
                    } else {
                        ++left;
                    }
                }
            }

            return list;
        }
    }
}
