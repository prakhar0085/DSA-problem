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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> mainList = new ArrayList<>();
       levelOrder(root , mainList);
    
        return mainList;

        
    }
    private void levelOrder(TreeNode root , List<List<Integer>> mainList){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> currlevel = new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode == null){
               mainList.add(new ArrayList<>(currlevel));
               currlevel.clear();
                if(q.isEmpty()){
                    break;
                }else{
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

    }
}