public class Solution {
    class Result {
        int max;
        int maxInclusive;

        Result(int max, int maxInclusive) {
            this.max = max;
            this.maxInclusive = maxInclusive;
        }
    }

    public int longestConsecutive(TreeNode root) {
        return helper(root).max;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }

        int max = 1, maxInclusive = 1;

        if (root.left != null) {
            Result leftResult = helper(root.left);

            int leftMaxInclusive, leftMax;

            if (root.left.val == root.val + 1) {
                leftMaxInclusive = leftResult.maxInclusive + 1;
                leftMax = Math.max(leftMaxInclusive, leftResult.max);
            } else {
                leftMaxInclusive = 1;
                leftMax = leftResult.max;
            }

            if (leftMaxInclusive > maxInclusive) {
                maxInclusive = leftMaxInclusive;
            }

            if (leftMax > max) {
                max = leftMax;
            }
        }

        if (root.right != null) {
            Result rightResult = helper(root.right);

            int rightMaxInclusive, rightMax;

            if (root.right.val == root.val + 1) {
                rightMaxInclusive = rightResult.maxInclusive + 1;
                rightMax = Math.max(rightMaxInclusive, rightResult.max);
            } else {
                rightMaxInclusive = 1;
                rightMax = rightResult.max;
            }

            if (rightMaxInclusive > maxInclusive) {
                maxInclusive = rightMaxInclusive;
            }

            if (rightMax > max) {
                max = rightMax;
            }
        }

        return new Result(max, maxInclusive);
    }
}
