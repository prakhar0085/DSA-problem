class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer , Integer> h = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for(int i = nums2.length -1 ; i >= 0 ; i--){
            while(!s.isEmpty() && nums2[s.peek()] <= nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                h.put(nums2[i] , -1);
            }else{
                h.put(nums2[i] , nums2[s.peek()]);
            }
            s.push(i);
        }
        int result[] = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            result[i] = h.get(nums1[i]);
    }

        return result;
        
    }
}