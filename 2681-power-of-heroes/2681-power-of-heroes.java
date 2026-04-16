class Solution {
    public int sumOfPower(int[] nums) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);

        long result = 0;
        long prefix = 0;

        for (int x : nums) {
            long val = (long)x * x % mod;

            result = (result + val * (x + prefix) % mod) % mod;

            prefix = (prefix * 2 + x) % mod;
        }

        return (int) result;
    }
}