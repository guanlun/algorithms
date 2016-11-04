public class WordDistance {
    HashMap<String, ArrayList<Integer>> indicesLookup;

    public WordDistance(String[] words) {
        indicesLookup = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            ArrayList<Integer> indices = indicesLookup.get(w);

            if (indices == null) {
                indices = new ArrayList<Integer>();
                indicesLookup.put(w, indices);
            }

            indices.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> indices1 = indicesLookup.get(word1);
        ArrayList<Integer> indices2 = indicesLookup.get(word2);

        int minDist = Integer.MAX_VALUE;

        int i1 = 0, i2 = 0;

        while (i1 < indices1.size() && i2 < indices2.size()) {
            int w1Index = indices1.get(i1);
            int w2Index = indices2.get(i2);

            int dist = Math.abs(w1Index - w2Index);

            if (dist < minDist) {
                minDist = dist;
            }

            if (w1Index < w2Index) {
                i1++;
            } else {
                i2++;
            }
        }

        return minDist;
    }
}
