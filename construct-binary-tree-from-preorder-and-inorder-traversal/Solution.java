/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderLookup = new HashMap<Integer, Integer>();
        Stack<Integer> currPath = new Stack<Integer>();
        TreeNode[] nodes = new TreeNode[inorder.length];
        
        TreeNode root = null;
        
        for (int i = 0; i < inorder.length; i++) {
            int val = inorder[i];
            
            nodes[i] = new TreeNode(val);
            
            inorderLookup.put(val, i);
        }
        
        for (int i = 0; i < preorder.length; i++) {
            int val = preorder[i];
            int inorderIndex = inorderLookup.get(val);
            TreeNode node = nodes[inorderIndex];
            
            if (root == null) {
                root = node;
                
            } else {
                int prevIndex = currPath.peek();
                
                if (inorderIndex < prevIndex) {
                    TreeNode parentNode = nodes[prevIndex];
                    
                    parentNode.left = node;
                } else {
                    int parentIndex = prevIndex;
                    
                    while (inorderIndex > prevIndex) {
                        currPath.pop();
                        
                        parentIndex = prevIndex;
                        
                        if (currPath.empty()) {
                            break;
                        }

                        prevIndex = currPath.peek();
                    }
                    
                    TreeNode parentNode = nodes[parentIndex];
                    
                    parentNode.right = node;
                }
            }
            
            currPath.push(inorderIndex);
        }
        
        return root;
    }
}
