public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Boolean> lookup = new HashMap<String, Boolean>();
        ArrayList<String> result = new ArrayList<String>();

        int len = s.length();

        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);

            Boolean added = lookup.get(sub);

            if (added == null) {
                lookup.put(sub, false);
            } else if (added == false) {
                result.add(sub);
                lookup.put(sub, true);
            }
        }

        return result;
    }
}
