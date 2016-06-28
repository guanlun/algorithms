public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> sortedLookup = new HashMap<String, ArrayList<String>>();
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            this.sortCharArray(charArray, 0, charArray.length - 1);
            
            String key = String.valueOf(charArray);
            
            ArrayList<String> anagrams = sortedLookup.get(key);
            
            if (anagrams == null) {
                anagrams = new ArrayList<String>();
                anagrams.add(s);
                sortedLookup.put(key, anagrams);
            } else {
                anagrams.add(s);
            }
        }
        
        return new ArrayList<List<String>>(sortedLookup.values());
    }
    
    private void sortCharArray(char[] charArray, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = (left + right) >> 1;
        char pivot = charArray[mid];
        int i = left, j = right;
        
        while (i < j) {
            while (charArray[i] < pivot) {
                i++;
            }
            
            while (charArray[j] > pivot) {
                j--;
            }
            
            if (i <= j) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        
        sortCharArray(charArray, left, j);
        sortCharArray(charArray, i, right);
    }
}
