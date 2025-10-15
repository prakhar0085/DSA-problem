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
    public int getMax(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(getMax(node.left) , getMax(node.right));
    }
    int result;
    public int amountOfTime(TreeNode root, int start) {
        result = 0;
        calCulateBurn(root , start);
        return result;
        
    }

    public int calCulateBurn(TreeNode root , int start){
        if(root == null){
            return -1;
        }
        if(root.val == start){
            int maxDepth = Math.max(getMax(root.left) , getMax(root.right));
            result = Math.max(result , maxDepth);
            return 0;
        }

        int leftDist = calCulateBurn(root.left , start);
        int rightDist = calCulateBurn(root.right , start);

        if(leftDist >= 0){
            result = Math.max(result , leftDist + 1 + getMax(root.right));
            return leftDist + 1;
        }
        if(rightDist >= 0){
            result = Math.max(result , rightDist + 1 + getMax(root.left));
            return rightDist + 1;
        }

        return -1;
    }
}