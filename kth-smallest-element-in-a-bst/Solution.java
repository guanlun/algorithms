public class Solution {
    class SearchStatus {
        boolean found;
        int val;
        
        public SearchStatus(boolean f, int v) {
            found = f;
            val = v;
        }
    }

    private int numOfSmaller;
    
    private SearchStatus visitNode(TreeNode node) {
        if (node == null) {
            return new SearchStatus(false, 0);
        }
        
        SearchStatus resultLeft = visitNode(node.left);
        if (resultLeft.found) {
            return resultLeft;
        }
        numOfSmaller--;
        
        if (numOfSmaller == 0) {
            return new SearchStatus(true, node.val);
        }
        
        SearchStatus resultRight = visitNode(node.right);
        if (resultRight.found) {
            return resultRight;
        }
        
        return new SearchStatus(false, 0);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        numOfSmaller = k;
        
        return visitNode(root).val;
    }
}
