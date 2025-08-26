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
class Solution {
    private int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxsum;
        
    }
    private int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(0 , maxGain(root.left));
        int rightGain = Math.max(0 , maxGain(root.right));
        int currmax = root.val +leftGain + rightGain;
        maxsum = Math.max(maxsum , currmax);

        return root.val + Math.max(leftGain , rightGain);

    }
}