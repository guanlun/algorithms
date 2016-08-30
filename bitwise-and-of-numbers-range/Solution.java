public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        
        // Use long here to prevent overflow when comparing numbers with 1 in their most significant digit
        long comparator = 1;
        int result = 0;
        
        while (true) {
            if (m < comparator && n >= comparator) {
                return 0;
            }
            
            if (comparator > n) {
                break;
            }
            
            comparator <<= 1;
        }
        
        comparator >>= 1;
        
        while ((m & comparator) == (n & comparator)) {
            result |= m & comparator;
            
            m ^= comparator;
            n ^= comparator;
            comparator >>= 1;
        }
        
        return result;
    }
}
