import java.util.Stack;

class Solution {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Left boundaries calculate karo
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Right boundaries calculate karo
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i - left[i]) * (right[i] - i);
            sum = (sum + arr[i] * count) % MOD;
        }

        return (int) sum;
    }
}