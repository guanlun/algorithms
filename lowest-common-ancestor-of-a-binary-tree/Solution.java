public class Solution {
    class SearchResult {
        int numFound;
        TreeNode ancestor;
        
        SearchResult() {
            numFound = 0;
            ancestor = null;
        }
    }
    
    public SearchResult search(TreeNode curr, TreeNode p, TreeNode q) {
        SearchResult result = new SearchResult();
        
        if (curr == null) {
            return result;
        }
        
        SearchResult leftResult = search(curr.left, p, q);
        SearchResult rightResult = search(curr.right, p, q);
        
        if (leftResult.ancestor != null) {
            return leftResult;
        } else if (rightResult.ancestor != null) {
            return rightResult;
        }
        
        result.numFound = leftResult.numFound + rightResult.numFound;
        
        if ((curr == p) || (curr == q)) {
            result.numFound++;
        }
        
        if (result.numFound == 2) {
            result.ancestor = curr;
        }
        
        return result;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q).ancestor;
    }
}
