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
    class Result {
        int min;
        int max;
        int size;
        boolean isBST;
        
        Result(int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Result result = recur(root);
        
        return result.size;
    }
    
    public Result recur(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MAX_VALUE, -Integer.MAX_VALUE, 0, true);
        }

        Result leftResult = recur(node.left);
        Result rightResult = recur(node.right);

        if (leftResult.isBST && rightResult.isBST && (node.val > leftResult.max) && (node.val < rightResult.min)) {
            return new Result(
                Math.min(node.val, leftResult.min), 
                Math.max(node.val, rightResult.max), 
                leftResult.size + rightResult.size + 1, 
                true
            );
        } else {
            return new Result(
                leftResult.min, 
                rightResult.max, 
                Math.max(leftResult.size, rightResult.size), 
                false
            );
        }
    }
}
