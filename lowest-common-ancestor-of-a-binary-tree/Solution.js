var search = function(curr, p, q) {
    if (!curr) {
        return null;
    }
    
    var leftResult = search(curr.left, p, q);
    var rightResult = search(curr.right, p, q);
    
    if ((leftResult && rightResult) || ((curr == p) || (curr == q))) {
        return curr;
    } else if (leftResult) {
        return leftResult;
    } else if (rightResult) {
        return rightResult;
    }
    
    return null;
}

var lowestCommonAncestor = function(root, p, q) {
    return search(root, p, q);
};
