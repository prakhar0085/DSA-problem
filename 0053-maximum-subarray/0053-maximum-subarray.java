class Solution {
    public int maxSubArray(int[] nums) {
        // int maxsum = nums[0]; // initialize with first element
        // int cs = nums[0];     // start with first element

        // for (int i = 1; i < nums.length; i++) {
        //     cs = Math.max(nums[i], cs + nums[i]); // choose between starting new or continuing
        //     maxsum = Math.max(maxsum, cs);        // update global max
        // }

        // return maxsum;
        int n = nums.length;
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
}
