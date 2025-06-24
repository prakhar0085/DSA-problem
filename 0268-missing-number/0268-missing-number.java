class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int sum2 = 0;
        for(int i = 0 ; i <= n-1 ; i++){
            sum2 += nums[i];
        }
        int missing = sum - sum2;
        return missing;
        
    }
}