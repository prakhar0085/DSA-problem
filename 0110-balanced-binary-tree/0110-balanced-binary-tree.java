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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }
    
    // Returns height if balanced, -1 if not balanced
    private int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;  // Height of empty tree is 0
        }
        
        // Check left subtree
        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1;  // Left subtree not balanced
        
        // Check right subtree
        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;  // Right subtree not balanced
        
        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Current node not balanced
        }
        
        // Return height of current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}