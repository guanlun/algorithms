public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> curr = new LinkedList<String>();

        curr.add(beginWord);

        int dist = 0;

        while (!curr.isEmpty()) {
            dist++;

            int len = curr.size();

            for (int i = 0; i < len; i++) {
                String currWord = curr.poll();

                for (int j = 0; j < currWord.length(); j++) {
                    char[] arr = currWord.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;

                        String changedStr = new String(arr);

                        if (changedStr.equals(endWord)) {
                            return dist + 1;
                        }

                        if (wordList.contains(changedStr)) {
                            wordList.remove(changedStr);

                            curr.add(changedStr);
                        }
                    }
                }
            }
        }

        // No sequence found
        return 0;
    }
}
