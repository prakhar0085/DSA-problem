/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        // Choose
        path.add(node.val);

        // If leaf and sum matches, add path to result
        if (node.left == null && node.right == null && remainingSum == node.val) {
            res.add(new ArrayList<>(path)); // copy current path
        } else {
            // Explore
            dfs(node.left, remainingSum - node.val, path, res);
            dfs(node.right, remainingSum - node.val, path, res);
        }

        // Un-choose (backtrack)
        path.remove(path.size() - 1);
    }
}
