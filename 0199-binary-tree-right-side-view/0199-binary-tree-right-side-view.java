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

class Info{
        TreeNode node;
        int level;
        Info(TreeNode node , int level){
            this.node = node;
            this.level = level;
        }
    }
class Solution {
  
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , TreeNode> map = new HashMap<>();
        int maxlevel = 0;
        q.add(new Info(root , 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) break;
                else q.add(null);
            }else{
                if(!map.containsKey(curr.level)){
                    map.put(curr.level , curr.node);
                    maxlevel = Math.max(maxlevel , curr.level);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right , curr.level + 1));
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left , curr.level + 1));
                }
            }
        }
        for(int i = 0 ; i <= maxlevel ; i++){
            if(map.containsKey(i)){
                result.add(map.get(i).val);
            }
        }
        return result;

        
    }
}