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
    public void flatten(TreeNode root) {
        flattenSub(root);
    }
    
    private TreeNode flattenSub(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        if (node.left == null && node.right == null) {
            return node;
        }
        
        if (node.left == null) {
            return flattenSub(node.right);
        }
        
        TreeNode leftLast = flattenSub(node.left);
        TreeNode rightLast = flattenSub(node.right);
        
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        
        node.left = null;
        node.right = leftChild;
        
        leftLast.right = rightChild;
        
        if (rightChild == null) {
            return leftLast;
        } else {
            return rightLast;
        }
    }
}
