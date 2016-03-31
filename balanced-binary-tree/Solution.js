var checkDepth = function(node) {
    if (!node) {
        return {
            depth: 0,
            balanced: true
        };
    }
    
    var leftResult = checkDepth(node.left);
    if (!leftResult.balanced) {
        return {
            balanced: false
        };
    }
    
    var rightResult = checkDepth(node.right);
    if (!rightResult.balanced) {
        return {
            balanced: false
        };
    }
    
    if (Math.abs(leftResult.depth - rightResult.depth) > 1) {
        return {
            balanced: false
        };
    }
    
    return {
        depth: Math.max(leftResult.depth, rightResult.depth) + 1,
        balanced: true,
    }
};

var isBalanced = function(root) {
    if (!root) {
        return true;
    }
    
    return checkDepth(root).balanced;
};
