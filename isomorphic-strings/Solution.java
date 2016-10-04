public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> lookup = new HashMap<Character, Character>();
        HashMap<Character, Character> reverseLookup = new HashMap<Character, Character>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            Character prevT = lookup.get(cs);

            if (prevT == null) {
                lookup.put(cs, ct);
            } else if (prevT != ct) {
                return false;
            }

            Character prevS = reverseLookup.get(ct);

            if (prevS == null) {
                reverseLookup.put(ct, cs);
            } else if (prevS != cs) {
                return false;
            }
        }

        return true;
    }
}
