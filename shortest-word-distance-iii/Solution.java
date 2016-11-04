public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;

        if (word1.equals(word2)) {
            int lastPos = -1;

            for (int i = 0; i < words.length; i++) {
                String w = words[i];

                if (w.equals(word1)) {
                    if (lastPos != -1) {
                        minDist = Math.min(minDist, i - lastPos);
                    }

                    lastPos = i;
                }
            }
        } else {
            int lastPos1 = -1;
            int lastPos2 = -1;

            for (int i = 0; i < words.length; i++) {
                String w = words[i];

                if (w.equals(word1)) {
                    lastPos1 = i;
                    if (lastPos2 != -1) {
                        minDist = Math.min(minDist, i - lastPos2);
                    }

                } else if (w.equals(word2)) {
                    lastPos2 = i;
                    if (lastPos1 != -1) {
                        minDist = Math.min(minDist, i - lastPos1);
                    }
                }
            }
        }

        return minDist;
    }
}
