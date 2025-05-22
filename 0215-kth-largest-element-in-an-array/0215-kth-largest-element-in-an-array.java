class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            count++;
            if(count == k){
                return nums[i];
                
            }
        }
        return -1;
        
    }
}

// second method 
public static int kthlargestElement(int nums[] , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(pq.size() < k){
                
                pq.add(nums[i]);

            }
            else if(nums[i] > pq.peek()){
                pq.remove();
                pq.add(nums[i]);
            }
        }
        System.out.println("size is :" + pq.size());
        return pq.peek();
    }
