public class Solution {
    class ParenSet {
        public ParenSet(String v, int l, int d) {
            value = v;
            length = l;
            diff = d;
        };
        
        public String value;
        public int length;
        public int diff;
    }
    
    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<ParenSet> sets = new ArrayList<ParenSet>();
        
        if (n == 0) {
            return results;
        }
        
        sets.add(new ParenSet("(", 1, 1));
        
        int strLen = n * 2;
        
        for (int i = 1; i < strLen; i++) {
            while (sets.get(0).length == i) {
                ParenSet set = sets.remove(0);
                if (set.diff == 0) {
                    sets.add(new ParenSet(set.value + "(", i + 1, 1));
                } else if (((set.length + set.diff) / 2) == n) {
                    sets.add(new ParenSet(set.value + ")", i + 1, set.diff - 1));
                } else {
                    sets.add(new ParenSet(set.value + "(", i + 1, set.diff + 1));
                    sets.add(new ParenSet(set.value + ")", i + 1, set.diff - 1));
                }
            }
        }
        
        for (int i = 0; i < sets.size(); i++) {
            results.add(sets.get(i).value);
        }
        
        return results;
    }
}
