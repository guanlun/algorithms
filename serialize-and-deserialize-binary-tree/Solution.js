/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    var curr;
    var queue = [];
    var results = [];
    
    queue.push(root);
    
    while (queue.length !== 0) {
        curr = queue.shift();
        if (!curr) {
            results.push('x');
            continue;
        } else {
            results.push(curr.val);
        }
        
        queue.push(curr.left);
        queue.push(curr.right);
    }
    
    return results.join(',');
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    var vals = data.split(',');
    
    var root = null;
    var lastLevelNodes = [];
    var currLevelNodes = [];
    
    var numNextLevel = 1;

    var numRead;
    var overallIndex = 0;
    
    while (overallIndex < vals.length) {
        numRead = 0;
        for (var i = 0; i < numNextLevel; i++) {
            var val = vals[overallIndex];
            
            if (val === 'x') {
                overallIndex++;
                numRead++;
                continue;
            }
            
            val = parseInt(val);
            
            var parentIndex = Math.floor(numRead / 2);
            var parentNode = lastLevelNodes[parentIndex];
            
            var newNode = new TreeNode(val);
            
            if (parentNode) {
                if ((numRead % 2) === 0) {
                    parentNode.left = newNode;
                } else {
                    parentNode.right = newNode;
                }
            } else {
                // parent Node not found, must be root node
                root = newNode;
            }
            
            currLevelNodes.push(newNode);
            
            overallIndex++;
            numRead++;
        }
        
        lastLevelNodes = currLevelNodes;
        currLevelNodes = [];
        
        numNextLevel = lastLevelNodes.length * 2;
    }
    
    return root;
};
