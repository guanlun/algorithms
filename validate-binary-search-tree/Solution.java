public class Solution {
    public boolean isValidBST(TreeNode root) {
        return recur(root, null, null);
    }
    
    private boolean recur(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        
        int val = root.val;
        
        if ((min != null) && (val <= min)) {
            return false;
        }
        
        if ((max != null) && (val >= max)) {
            return false;
        }

        return recur(root.left, min, val) && recur(root.right, val, max);
    }
}
