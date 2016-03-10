var recurView = function(curr, depth, maxDepth, results) {
    if (!curr) {
        return maxDepth;
    }
    
    if (depth === maxDepth) {
        results.push(curr.val);
        maxDepth++;
    }
    
    maxDepth = recurView(curr.right, depth + 1, maxDepth, results);
    maxDepth = recurView(curr.left, depth + 1, maxDepth, results);
    
    return maxDepth;
};

var rightSideView = function(root) {
    var results = [];
    if (!root) {
        return results;
    }
    
    recurView(root, 0, 0, results);
    
    return results;
};
