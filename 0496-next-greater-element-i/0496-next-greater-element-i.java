class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
       Map<Integer, Integer> nextGreater = new HashMap<>();
        for(int i = nums2.length -1 ; i >=0 ; i--){
            while(!s.isEmpty() && s.peek() <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater.put(nums2[i] , -1);
            }else{
                nextGreater.put(nums2[i] , s.peek());
            }
            s.push(nums2[i]);
        }
        int [] result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
        
    }
}