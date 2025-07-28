class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> resList = new ArrayList<>();
        
        // First window
        for (int i = 0; i < k; i++) {
            // Remove smaller values from back
            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        
        // Process remaining elements
        for (int i = k; i < nums.length; i++) {
            // Add maximum of previous window to result
            resList.add(nums[dq.peekFirst()]);
            
            // Remove elements not part of current window
            while (dq.size() > 0 && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            
            // Remove smaller values from back
            while (dq.size() > 0 && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            
            dq.offerLast(i);
        }
        
        // Add maximum of last window
        resList.add(nums[dq.peekFirst()]);
        
        // Convert List to array
        return resList.stream().mapToInt(i -> i).toArray();
    }

}