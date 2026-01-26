class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int num : nums){
            if(num > 0){
                pos.add(num);
            }else if (num < 0){
                neg.add(num);
            }
        }
        for(int i = 0 ; i < pos.size() && i < neg.size() ; i++){
            list.add(pos.get(i));
            list.add(neg.get(i));
        }
        return list.stream().mapToInt(i -> i).toArray();


        
    }
}


//         class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
        
//         int posIndex = 0;
//         int negIndex = 1;
        
//         for (int num : nums) {
//             if (num > 0) {
//                 ans[posIndex] = num;
//                 posIndex += 2;
//             } else {
//                 ans[negIndex] = num;
//                 negIndex += 2;
//             }
//         }
        
//         return ans;
//     }
// }

// "I increment by 2 because positives must always occupy even indices and negatives must occupy odd indices, so I skip one index each time."
