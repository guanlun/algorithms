/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return results;    
        }
                
        List<TreeNode> currRow = new ArrayList<TreeNode>();
        
        currRow.add(root);
        
        while (!currRow.isEmpty()) {            
            List<TreeNode> nextRow = new ArrayList<TreeNode>();
            
            List<Integer> rowResult = new ArrayList<Integer>();
            
            for (TreeNode n : currRow) {
                rowResult.add(n.val);
                
                if (n.left != null) {
                    nextRow.add(n.left);
                }
                
                if (n.right != null) {
                    nextRow.add(n.right);
                }
            }
            
            results.add(rowResult);
            
            currRow = nextRow;
        }
        
        Collections.reverse(results);
        
        return results;
    }
}
