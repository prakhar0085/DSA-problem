class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans , -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n -1 ; i >=0 ; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i % n]){
                s.pop();
            }
            ans[i % n] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % n);
        }
        return ans;
       
        
    }
}