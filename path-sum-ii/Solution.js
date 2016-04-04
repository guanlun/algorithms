var searchSum = function(currNode, currSum, targetSum, currPath, results) {
    if (!currNode) {
        return false;
    }
    
    var newSum = currSum + currNode.val;
    
    var newPath = currPath.slice(0);
    newPath.push(currNode.val);

    if (!currNode.left && !currNode.right) {
        if (newSum === targetSum) {
            results.push(newPath);
        }
    }
    
    searchSum(currNode.left, newSum, targetSum, newPath, results);
    
    searchSum(currNode.right, newSum, targetSum, newPath, results);
};

var pathSum = function(root, sum) {
    if (!root) {
        return [];
    }
    
    var results = [];
    
    searchSum(root, 0, sum, [], results);
    
    return results;
};
