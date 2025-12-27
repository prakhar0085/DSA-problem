class Solution {
    public int removeDuplicates(int[] nums) {
        // HashMap<Integer , Boolean> map = new HashMap<>();
        // int i = 0;
        // for(int num : nums){
        //     if(!map.containsKey(num)){
        //         map.put(num , true);
        //         nums[i] = num;
        //         i++;


        //     }

        // }
        // return i;
        HashSet<Integer> seen = new HashSet<>();
        int i = 0;
        for(int num : nums){
            if(!seen.contains(num)){
                seen.add(num);
                nums[i] = num;
                i++;
            }
        }
        return i;
        
    }
}