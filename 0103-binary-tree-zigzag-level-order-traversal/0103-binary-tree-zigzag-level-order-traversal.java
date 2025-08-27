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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean leftToRight = true;
        List<Integer> currlevel = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode == null){
                if(!leftToRight){
                    Collections.reverse(currlevel);
                }
                result.add(new ArrayList<>(currlevel));
                currlevel.clear();
                leftToRight = !leftToRight;

                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }

            }
            else{
                currlevel.add(currNode.val);
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }

            }
        } 
        return result;
        
    }
}