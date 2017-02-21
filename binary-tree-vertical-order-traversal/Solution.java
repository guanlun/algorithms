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
    class Record {
        int pos;
        TreeNode node;
        Record(int p, TreeNode n) {
            pos = p;
            node = n;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        result.add(new ArrayList<Integer>());
        
        List<Record> currLevel = new ArrayList<Record>();
        
        currLevel.add(new Record(0, root));
        
        int currMinPos = 0;
        
        while (!currLevel.isEmpty()) {
            List<Record> nextLevel = new ArrayList<Record>();
            
            for (Record r : currLevel) {
                if (r.pos < currMinPos) {
                    currMinPos = r.pos;
                    result.add(0, new ArrayList<Integer>());
                } else if (r.pos - currMinPos >= result.size()) {
                    result.add(new ArrayList<Integer>());
                }
                
                result.get(r.pos - currMinPos).add(r.node.val);
                
                if (r.node.left != null) {
                    nextLevel.add(new Record(r.pos - 1, r.node.left));
                }
                
                if (r.node.right != null) {
                    nextLevel.add(new Record(r.pos + 1, r.node.right));
                }
            }
            
            currLevel = nextLevel;
        }
        
        return result;
    }
}
