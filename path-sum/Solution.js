var searchSum = function(currNode, currSum, targetSum) {
    if (!currNode) {
        return false;
    }
    
    var newSum = currSum + currNode.val;

    if (!currNode.left && !currNode.right) {
        return (newSum === targetSum);
    }
    
    return searchSum(currNode.left, newSum, targetSum) || searchSum(currNode.right, newSum, targetSum);
};

var hasPathSum = function(root, sum) {
    if (!root) {
        return false;
    }
    
    return searchSum(root, 0, sum);
};
