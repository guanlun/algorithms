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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int target = p.val;
        int min = Integer.MAX_VALUE;
        TreeNode node = root;
        TreeNode nextNode = null;
        
        while (node != null) {
            if (target < node.val) {
                if (node.val < min) {
                    min = node.val;
                    nextNode = node;
                }

                node = node.left;
            } else {
                node = node.right;
            }
        }
        
        return nextNode;
    }
}
