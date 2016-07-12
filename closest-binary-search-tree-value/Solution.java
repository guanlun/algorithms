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
    private int currClosest;
    private double currDiff;
    
    public int closestValue(TreeNode root, double target) {
        currDiff = Double.MAX_VALUE;
        
        recur(root, target);
        
        return currClosest;
    }
    
    private void recur(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        
        double diff = Math.abs(node.val - target);
        
        if (diff < this.currDiff) {
            this.currDiff = diff;
            this.currClosest = node.val;
        }
        
        if (target < node.val) {
            recur(node.left, target);
        } else {
            recur(node.right, target);
        }
    }
}
