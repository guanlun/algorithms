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
    private int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        
        findUnivalSubTree(root);
        
        return count;
    }
    
    private boolean findUnivalSubTree(TreeNode curr) {
        if (curr == null) {
            return true;
        }
        
        boolean leftResult = findUnivalSubTree(curr.left);
        boolean rightResult = findUnivalSubTree(curr.right);
        
        if (leftResult && rightResult) {
            if ((curr.left != null) && (curr.val != curr.left.val)) {
                return false;
            }
            
            if ((curr.right != null) && (curr.val != curr.right.val)) {
                return false;
            }
            
            count++;

            return true;
        }
        
        return false;
    }
}
