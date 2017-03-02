public class Solution {
    public boolean validUtf8(int[] data) {
        int idx = 0;
        int len = data.length;
        
        while (idx < len) {
            if ((data[idx] & 128) == 0) {
                // first bit is 0
            } else {
                if ((data[idx] & 64) == 0) {
                    // second bit is 0
                    return false;
                } else {
                    boolean metAny = false;
                    
                    for (int charLen = 2; charLen <= 4; charLen++) {
                        if ((data[idx] & (128 >>> charLen)) == 0) {
                            metAny = true;
                            
                            if (idx > len - charLen) {
                                return false;
                            }
                            
                            for (int i = 0; i < charLen - 1; i++) {
                                idx++;
                                if (!beginsWith10(data[idx])) {
                                    return false;
                                }
                            }
                            
                            break;
                        }
                    }
                    
                    if (!metAny) {
                        return false;
                    }
                }
            }
            
            idx++;
        }
        
        return true;
    }
    
    private boolean beginsWith10(int n) {
        return ((n & 128) != 0) && ((n & 64) == 0);
    }
}
