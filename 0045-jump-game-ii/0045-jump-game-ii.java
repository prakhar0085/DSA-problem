class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;    // end of current jump range
        int farthest = 0;     // farthest reachable index

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // when we reach the end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}