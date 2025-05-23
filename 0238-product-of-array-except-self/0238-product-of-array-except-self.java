class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n]; // Declare and initialize answer array

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }

        return answer; // Return the whole array
    }
}

// Optimal approch TC-0(N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n]; // Declare and initialize answer array

       // Return the whole array
       int prefix[] = new int[n];

       prefix[0] = 1;
       for(int i = 1 ; i < n ; i++){
        prefix[i] = prefix[i-1]*nums[i-1];
       }

       int suffix[] = new int[n];
       suffix[n-1] = 1;
       for(int i = n-2  ; i>=0 ; i--){
        suffix[i] = suffix[i+1] * nums[i+1];
       }

       for(int i = 0 ; i < n ;i++){
        answer[i] = prefix[i] * suffix[i];
       }

       return answer;
    }
}

