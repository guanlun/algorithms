/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        
        root.left.next = root.right;
        
        connect(root.left);
        connect(root.right);
        
        connectAcross(root.left, root.right);
    }

    private void connectAcross(TreeLinkNode leftNode, TreeLinkNode rightNode) {
        if (leftNode == null) {
            return;
        }

        leftNode.next = rightNode;
        connectAcross(leftNode.right, rightNode.left);
    }
}
