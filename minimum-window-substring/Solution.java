public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        HashMap<Character, Integer> lookup = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            lookup.put(c, 0);

            Integer targetCount = target.get(c);

            if (targetCount == null) {
                target.put(c, 1);
            } else {
                target.put(c, targetCount + 1);
            }
        }

        int leftIndex = 0;

        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            char newC = s.charAt(rightIndex);
            Integer count = lookup.get(newC);

            if (count == null) {
                continue;
            }

            lookup.put(newC, count + 1);

            if (!containsAll(lookup, target)) {
                continue;
            }

            while (leftIndex <= rightIndex) {
                char lastC = s.charAt(leftIndex);

                Integer lastCount = lookup.get(lastC);

                if (lastCount == null) {
                    leftIndex++;
                    continue;
                }

                lookup.put(lastC, lastCount - 1);

                if (!containsAll(lookup, target)) {
                    int currLen = rightIndex - leftIndex + 1;

                    if (currLen < minLen) {
                        minLen = currLen;

                        result = s.substring(leftIndex, rightIndex + 1);
                    }

                    leftIndex++;

                    break;
                }

                leftIndex++;
            }
        }

        return result;
    }

    private boolean containsAll(HashMap<Character, Integer> lookup, HashMap<Character, Integer> target) {
        for (HashMap.Entry<Character, Integer> entry : target.entrySet()) {
            char c = entry.getKey();

            if (lookup.get(c) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
