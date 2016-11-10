public class Solution {
    class Tuple implements Comparable {
        char val;
        int count;

        Tuple(char val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public int compareTo(Object o) {
            Tuple t = (Tuple) o;
            return t.count - this.count;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            Integer count = lookup.get(c);

            if (count == null) {
                lookup.put(c, 1);
            } else {
                lookup.put(c, count + 1);
            }
        }

        ArrayList<Tuple> items = new ArrayList<Tuple>();

        for (HashMap.Entry<Character, Integer> entry : lookup.entrySet()) {
            items.add(new Tuple(entry.getKey(), entry.getValue()));
        }

        Collections.sort(items);

        StringBuilder result = new StringBuilder(s.length());

        for (Tuple t : items) {
            for (int i = 0; i < t.count; i++) {
                result.append(t.val);
            }
        }

        return result.toString();
    }
}
