public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumFrom(root, 0);
    }
    
    private int sumFrom(TreeNode node, int currSum) {
        if (node == null) {
            return 0;
        }
        
        currSum = currSum * 10 + node.val;

        int leftSum = sumFrom(node.left, currSum);
        int rightSum = sumFrom(node.right, currSum);
        
        if ((leftSum == 0) && (rightSum == 0)) {
            return currSum;
        } else {
            return leftSum + rightSum;
        }
    }
}
