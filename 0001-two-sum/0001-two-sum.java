class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap<Integer , Integer> map = new HashMap<>();
        // for (int i = 0 ; i < nums.length ; i++){
        //     int first = nums[i];
        //     int second = target - first;
        //     if(map.containsKey(second)){
        //         return new int[]{map.get(second) , i};
        //     }
        //     map.put(nums[i] , i);
        // } 
        // return new int[] {-1 , -1};   

        int  n = nums.length;
        for(int i = 0; i < n ; i++){
            int first = nums[i];
            for(int j = i+1 ; j < n ; j++){
                int second = nums[j];
                int sum = first + second;
                if(sum == target){
                    return new int[] {i , j};
                }
            }
        } 
        return new int[] {-1 , -1};  
    }
}