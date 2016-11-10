public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> results = new ArrayList<String>();

        helper(results, "", root);

        return results;
    }

    private void helper(List<String> results, String currPath, TreeNode node) {
        if (node == null) {
            return;
        }

        String newPath;

        if (currPath.length() == 0) {
            newPath = "" + node.val;
        } else {
            newPath = currPath + "->" + node.val;
        }

        if (node.left == null && node.right == null) {
            results.add(newPath);
        } else {
            helper(results, newPath, node.left);
            helper(results, newPath, node.right);
        }
    }
}
