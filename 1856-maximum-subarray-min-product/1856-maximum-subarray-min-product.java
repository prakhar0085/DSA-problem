class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long mod = 1_000_000_007;

        // Step 1: Compute prefix sum (1-based indexing)
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 2: Monotonic stack to find previous smaller element (left boundary)
        int[] left = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Step 3: Monotonic stack to find next smaller element (right boundary)
        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Step 4: Calculate max min-product
        long result = 0;
        for (int i = 0; i < n; i++) {
            long subarraySum = prefix[right[i]] - prefix[left[i] + 1];
            result = Math.max(result, subarraySum * nums[i]);
        }

        return (int)(result % mod);
    }
}
