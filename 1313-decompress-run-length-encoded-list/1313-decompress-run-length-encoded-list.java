class Solution {
    public int[] decompressRLElist(int[] nums) {
        // First pass: calculate total length of decompressed array
        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];  // freq
        }

        // Create result array of required size
        int[] res = new int[size];
        int idx = 0;

        // Second pass: fill the result array
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];

            for (int j = 0; j < freq; j++) {
                res[idx++] = val;
            }
        }

        return res;
    }
}
