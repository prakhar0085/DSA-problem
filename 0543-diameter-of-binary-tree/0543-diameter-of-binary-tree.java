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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lD = diameterOfBinaryTree(root.left);
        int rD = diameterOfBinaryTree(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfdiam = lh + rh ;
        return Math.max(Math.max(lD , rD) , selfdiam);
        
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.max(lh , rh) + 1;
        return height;
    }
}