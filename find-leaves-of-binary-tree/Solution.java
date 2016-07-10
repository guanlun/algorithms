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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        search(results, root);
        
        return results;
    }
    
    private int search(List<List<Integer>> results, TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftResult = search(results, node.left);
        int rightResult = search(results, node.right);
        
        int order = Math.max(leftResult, rightResult) + 1;

        List<Integer> resultAtOrder;
        
        if (order > results.size()) {
            resultAtOrder = new ArrayList<Integer>();
            results.add(resultAtOrder);
        } else {
            resultAtOrder = results.get(order - 1);
        }
        
        resultAtOrder.add(node.val);
        
        return order;
    }
}
