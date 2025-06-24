class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            int start = 0;
            int end = nums.length-1;
            while(start <= end){
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
                end--;
            }
            return;
        }
        for(int i = n-1 ; i > pivot ; i--){
            if(nums[i] > nums[pivot]){
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        int i = pivot + 1;
        int j = n-1;
        while(i <= j){
             int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;

        }
        
    }
}