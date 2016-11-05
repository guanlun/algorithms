public class Solution {
    private int singleSum;
    private int sum;
    private int maxDepth;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        singleSum = 0;
        sum = 0;
        maxDepth = 1;

        helper(nestedList, 1);

        return sum;
    }

    private void helper(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                if (depth > maxDepth) {
                    sum += singleSum * (depth - maxDepth);
                    maxDepth = depth;
                }
                sum += ni.getInteger() * (maxDepth - depth + 1);
                singleSum += ni.getInteger();
            } else {
                helper(ni.getList(), depth + 1);
            }
        }
    }
}
