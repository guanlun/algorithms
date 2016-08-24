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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        return arrayRangeToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode arrayRangeToBST(int[] nums, int from, int to) {
        if (from == to) {
            return new TreeNode(nums[from]);
        }
        
        int mid = (from + to) >> 1;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        if (from < mid) {
            node.left = arrayRangeToBST(nums, from, mid - 1);
        }
        
        if (mid < to) {
            node.right = arrayRangeToBST(nums, mid + 1, to);
        }
        
        return node;
    }
}