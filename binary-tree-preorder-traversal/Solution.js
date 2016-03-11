var preorderTraversal = function(root) {
    var results = [];
    var stack = [];
    
    var curr = root;
    
    while (curr) {
        results.push(curr.val);
        
        if (curr.right) {
            stack.push(curr.right);
        }
        
        if (curr.left) {
            stack.push(curr.left);
        }
        
        curr = stack.pop();
    }
    
    return results;
};
