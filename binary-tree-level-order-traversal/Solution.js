var levelOrder = function(root) {
    var results = [];
    
    if (!root) {
        return results;
    }
    
    var currLevel = [];
    var prevLevel;
    currLevel.push(root);
    
    results.push([root.val]);
    
    while (true) {
        prevLevel = currLevel;
        currLevel = [];
        for (var i = 0; i < prevLevel.length; i++) {
            var node = prevLevel[i];
            if (node.left) {
                currLevel.push(node.left);
            }
            if (node.right) {
                currLevel.push(node.right);
            }
        }
        
        if (currLevel.length === 0) {
            break;
        }
        
        var nums = [];
        for (i = 0; i < currLevel.length; i++) {
            nums.push(currLevel[i].val);
        }
        
        results.push(nums);
    }
    
    return results;
};
