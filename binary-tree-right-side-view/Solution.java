/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        
        recur(root, 0, results);
        
        return results;
    }
    
    private void recur(TreeNode curr, int depth, List<Integer> results) {
        if (curr == null) {
            return;
        }
        
        if (depth >= results.size()) {
            results.add(curr.val);
        }
        
        recur(curr.right, depth + 1, results);
        recur(curr.left, depth + 1, results);
    }
}
