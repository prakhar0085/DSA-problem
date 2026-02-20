import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);                 // sort to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // deep copy
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // 🔴 Skip duplicates:
            // If current number is same as previous and previous was NOT used in this branch,
            // then skip to avoid duplicate permutations.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // choose
            used[i] = true;
            current.add(nums[i]);

            // explore
            backtrack(nums, current, used, result);

            // un-choose (backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}