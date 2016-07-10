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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        Stack<TreeNode> currNodes = new Stack<TreeNode>();
        
        TreeNode curr = root;
        
        while (curr != null || !currNodes.empty()) {
            while (curr != null) {
                currNodes.add(curr);
                curr = curr.left;
            }
            
            curr = currNodes.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        
        return result;
    }
}
