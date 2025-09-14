/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findTarget(root, target, k);
        return result;
    }
    
    // Returns distance from current node to target (-1 if target not in subtree)
    private int findTarget(TreeNode node, TreeNode target, int k) {
        if (node == null) return -1;
        
        // Found the target node
        if (node == target) {
            // Collect all nodes at distance k downward from target
            collectDown(node, k);
            return 0; // Distance from target to itself is 0
        }
        
        // Search in left subtree
        int leftDist = findTarget(node.left, target, k);
        if (leftDist >= 0) {
            // Target found in left subtree
            if (leftDist + 1 == k) {
                // Current node is at distance k from target
                result.add(node.val);
            } else {
                // Look in right subtree for remaining distance
                collectDown(node.right, k - leftDist - 2);
            }
            return leftDist + 1;
        }
        
        // Search in right subtree
        int rightDist = findTarget(node.right, target, k);
        if (rightDist >= 0) {
            // Target found in right subtree
            if (rightDist + 1 == k) {
                // Current node is at distance k from target
                result.add(node.val);
            } else {
                // Look in left subtree for remaining distance
                collectDown(node.left, k - rightDist - 2);
            }
            return rightDist + 1;
        }
        
        return -1; // Target not found in this subtree
    }
    
    // Collect all nodes at exactly distance d downward from current node
    private void collectDown(TreeNode node, int d) {
        if (node == null || d < 0) return;
        
        if (d == 0) {
            result.add(node.val);
            return;
        }
        
        collectDown(node.left, d - 1);
        collectDown(node.right, d - 1);
    }
}