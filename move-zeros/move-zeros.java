public class Solution {
    public void moveZeroes(int[] nums) {
        int searchFrom = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (searchFrom <= i) {
                searchFrom = i + 1;
            }
            
            if (nums[i] == 0) {
                while (true) {
                    if (searchFrom == nums.length) {
                        return;
                    }
                    
                    if (nums[searchFrom] != 0) {
                        break;
                    }
                    
                    searchFrom++;
                }
                
                int temp = nums[searchFrom];
                nums[searchFrom] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
