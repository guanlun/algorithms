public class Solution {
    private TreeNode newRoot;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        newRoot = null;

        helper(root);

        root.left = null;
        root.right = null;

        return newRoot;
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode leftNode = helper(node.left);

        if (leftNode == null) {
            newRoot = node;
            return newRoot;
        }

        leftNode.left = node.right;
        leftNode.right = node;

        return node;
    }
}
