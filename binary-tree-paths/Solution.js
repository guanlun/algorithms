var recurListPath = function(node, currPath, results) {
    if (!node) {
        return;
    }
    
    if (currPath.length === 0) {
        currPath += node.val;
    } else {
        currPath += '->' + node.val;
    }
    
    if (!node.left && !node.right) {
        results.push(currPath);
    } else {
        recurListPath(node.left, currPath, results);
        recurListPath(node.right, currPath, results);
    }
};

var binaryTreePaths = function(root) {
    var currPath = '';
    var results = [];
    
    recurListPath(root, currPath, results);
    
    return results;
};
