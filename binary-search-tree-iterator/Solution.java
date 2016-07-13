/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> path;

    public BSTIterator(TreeNode root) {
        path = new Stack<TreeNode>();
        
        addLeftPath(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !path.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (path.isEmpty()) {
            return -1;
        }
        
        TreeNode result = path.pop();
        
        addLeftPath(result.right);
        
        return result.val;
    }
    
    private void addLeftPath(TreeNode node) {
        while (node != null) {
            path.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
