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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return results;
        }
        
        boolean leftToRight = true;
        
        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        List<TreeNode> nextLevel = new ArrayList<TreeNode>();
        
        currLevel.add(root);
        
        while (!currLevel.isEmpty()) {
            for (TreeNode item : currLevel) {
                if (item.left != null) {
                    nextLevel.add(item.left);
                }
                
                if (item.right != null) {
                    nextLevel.add(item.right);
                }
            }
            
            ArrayList<Integer> currResult = new ArrayList<Integer>();
            
            if (leftToRight) {
                for (int i = 0; i < currLevel.size(); i++) {
                    currResult.add(currLevel.get(i).val);
                }
            } else {
                for (int i = currLevel.size() - 1; i >= 0; i--) {
                    currResult.add(currLevel.get(i).val);
                }
            }
            
            results.add(currResult);
            
            currLevel = nextLevel;
            nextLevel = new ArrayList<TreeNode>();
            
            leftToRight = !leftToRight;
        }
        
        return results;
    }
}
