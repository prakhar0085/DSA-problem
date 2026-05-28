import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // Flip negative numbers first
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        // If k is odd, flip the smallest number
        if (k % 2 == 1) {
            sum -= 2 * min;
        }

        return sum;
    }
}