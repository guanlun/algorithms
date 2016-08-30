public class Solution {
    public int[] countBits(int num) {
        int len = num + 1;
        int[] result = new int[len];
        result[0] = 0;
        
        int base = 1;
        int offset = 0;
        
        while (base + offset < len) {
            result[base + offset] = result[offset] + 1;
            offset++;
            
            if (offset == base) {
                offset = 0;
                base <<= 1;
            }
        }
        
        return result;
    }
}
