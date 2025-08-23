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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Postorder(root , result);
        return result;
        
    }
    private void Postorder(TreeNode root , ArrayList<Integer> result){
        if(root == null){
            return;
        }
        Postorder(root.left , result);
        Postorder(root.right , result);
        result.add(root.val);
    }
}