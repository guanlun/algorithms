public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] nums = new int[len];
        
        for (int i = 0; i < len; i++) {
            String word = words[i];
            
            for (int j = 0; j < word.length(); j++) {
                int n = word.charAt(j) - 97;
                nums[i] |= (1 << n);
            }
        }
        
        int maxProduct = 0;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    
                    if (product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }
        
        return maxProduct;
    }
}
