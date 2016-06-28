public class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        sort(nums, 0, len - 1);
        
        for (int i = 1; i < len; i += 2) {
            if (i + 1 == len) {
                return;
            }
            
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }
    
    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int middle = (left + right) >> 1;
        int pivot = nums[middle];
        int i = left, j = right;
        
        while (i < j) {
            while (nums[i] < pivot) {
                i++;
            }
            
            while (nums[j] > pivot) {
                j--;
            }
            
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                i++;
                j--;
            }
        }
        
        sort(nums, left, j);
        sort(nums, i, right);
    }
}
