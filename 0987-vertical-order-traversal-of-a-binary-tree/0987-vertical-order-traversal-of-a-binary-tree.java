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
class Info {
    TreeNode node;
    int row;    // vertical position (level)
    int col;    // horizontal position (column)
    
    Info(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        // Level order traversal
        Queue<Info> q = new LinkedList<>();
        // HashMap to store all nodes at each column
        HashMap<Integer, List<Info>> map = new HashMap<>();
        
        int min = 0, max = 0;
        q.add(new Info(root, 0, 0));
        q.add(null); // level separator
        
        while (!q.isEmpty()) {
            Info curr = q.remove();
            
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null); // add level separator for next level
                }
            } else {
                // Add current node to its column list
                if (!map.containsKey(curr.col)) {
                    map.put(curr.col, new ArrayList<>());
                }
                map.get(curr.col).add(curr);
                
                // Add left child
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.row + 1, curr.col - 1));
                    min = Math.min(min, curr.col - 1);
                }
                
                // Add right child
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.row + 1, curr.col + 1));
                    max = Math.max(max, curr.col + 1);
                }
            }
        }
        
        // Build result from min to max column
        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                List<Info> column = map.get(i);
                
                // Sort nodes in column: first by row, then by value
                column.sort((a, b) -> {
                    if (a.row != b.row) {
                        return Integer.compare(a.row, b.row);  // Row first
                    }
                    return Integer.compare(a.node.val, b.node.val);  // Then value
                });
                
                // Extract values and add to result
                List<Integer> columnValues = new ArrayList<>();
                for (Info info : column) {
                    columnValues.add(info.node.val);
                }
                result.add(columnValues);
            }
        }
        
        return result;
    }
}