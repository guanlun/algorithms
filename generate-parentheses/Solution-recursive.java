public class Solution {
    class ParenSet {
        public ParenSet(String v, int d) {
            value = v;
            diff = d;
        }
        public String value;
        public int diff;
    }
    
    public void genNew(ParenSet set, ArrayList<ParenSet> allSets, int num, int total) {
        if (num == total * 2) {
            allSets.add(set);
            return;
        }
        
        if (set.diff == 0) {
            genNew(new ParenSet(set.value + "(", set.diff + 1), allSets, num + 1, total);
        } else if (((set.diff + num) / 2) == total) {
            genNew(new ParenSet(set.value + ")", set.diff - 1), allSets, num + 1, total);
        } else {
            genNew(new ParenSet(set.value + "(", set.diff + 1), allSets, num + 1, total);
            genNew(new ParenSet(set.value + ")", set.diff - 1), allSets, num + 1, total);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<ParenSet> sets = new ArrayList<ParenSet>();
        
        if (n == 0) {
            return results;
        }
        
        ParenSet first = new ParenSet("(", 1);
        
        genNew(first, sets, 1, n);
        
        for (int i = 0; i < sets.size(); i++) {
            results.add(sets.get(i).value);
        }
        
        return results;
    }
}