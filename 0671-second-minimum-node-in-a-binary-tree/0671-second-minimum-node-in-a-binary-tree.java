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
    public int findSecondMinimumValue(TreeNode root) {
         Set<Integer> uniqueValues = new HashSet<>();
        collectValues(root, uniqueValues);
        
        // Convert to sorted list
        ArrayList<Integer> sortedList = new ArrayList<>(uniqueValues);
        Collections.sort(sortedList);
        
        // Return second minimum if exists
        if (sortedList.size() >= 2) {
            return sortedList.get(1);
        }
        return -1;
    }
     public static void collectValues(TreeNode root, Set<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        collectValues(root.left, values);
        collectValues(root.right, values);
    }
}