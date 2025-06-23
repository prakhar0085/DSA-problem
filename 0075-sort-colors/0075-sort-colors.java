class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        // Temporary arrays for 0s, 1s, and 2s
        int[] zeros = new int[n];
        int[] ones = new int[n];
        int[] twos = new int[n];

        int z = 0, o = 0, t = 0;

        // Step 1: Distribute numbers into groups
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros[z++] = 0;
            } else if (nums[i] == 1) {
                ones[o++] = 1;
            } else {
                twos[t++] = 2;
            }
        }

        // Step 2: Merge back into original array
        int index = 0;
        for (int i = 0; i < z; i++) {
            nums[index++] = zeros[i];
        }
        for (int i = 0; i < o; i++) {
            nums[index++] = ones[i];
        }
        for (int i = 0; i < t; i++) {
            nums[index++] = twos[i];
        }
    }
}
