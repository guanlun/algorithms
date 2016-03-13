var postorderTraversal = function(root) {
    var results = [];
    var stack = [];
    var top;
    
    if (!root) {
        return results;
    }
    
    stack.push({
        node: root,
        peeked: false
    });
    
    while (stack.length !== 0) {
        top = stack[stack.length - 1];
        
        if (top.peeked || (!top.node.left && !top.node.right)) {
            stack.pop();
            results.push(top.node.val);
            
            continue;
        }
        
        top.peeked = true;
        
        if (top.node.right) {
            stack.push({
                node: top.node.right,
                peeked: false
            });
        }        
        
        if (top.node.left) {
            stack.push({
                node: top.node.left,
                peeked: false
            });
        }
    }
    
    return results;
};
