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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //// Fix: Handle both null case first
        if(p == null && q == null){
            return true;
        }
        // // Then handle one null case
        if(p == null || q == null){
            return false;
        }

        if(p.val == q.val){
            if(isIdentical(p , q)){
                return true;
            }
        }
        return false;
    }
    public boolean isIdentical(TreeNode p, TreeNode q){
        if(p==null && q == null){
            return true;
        }
        else if(p == null || q == null || p.val != q.val){
            return false;
        }
        if(!isIdentical(p.left , q.left)){
            return false;
        }
        if(!isIdentical(p.right , q.right)){
            return false;
        }

        return true;
    }
}
