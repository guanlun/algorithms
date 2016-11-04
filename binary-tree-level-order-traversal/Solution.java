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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();

        currLevel.add(root);

        while (!currLevel.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            ArrayList<Integer> levelResult = new ArrayList<Integer>();

            for (TreeNode node : currLevel) {
                levelResult.add(node.val);

                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }

            currLevel = nextLevel;

            result.add(levelResult);
        }

        return result;
    }
}
