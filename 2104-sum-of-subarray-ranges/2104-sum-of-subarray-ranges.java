class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }
    
    private long sumSubarrayMax(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                sum += (long)nums[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        
        return sum;
    }
    
    private long sumSubarrayMin(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                sum += (long)nums[j] * (i - j) * (j - k);
            }
            stack.push(i);
        }
        
        return sum;
    }
}