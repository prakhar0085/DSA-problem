class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // important for duplicate handling
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            // stop if number exceeds target
            if (nums[i] > target) break;
            
            temp.add(nums[i]);
            backtrack(result, temp, nums, target - nums[i], i + 1); // i+1 because each element used once
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}