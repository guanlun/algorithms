public class NumArray {
    
    private int[] sums;

    public NumArray(int[] nums) {
        int len = nums.length;
        
        this.sums = new int[len];
        
        if (len == 0) {
            return;
        }
        
        this.sums[0] = nums[0];
        
        for (int i = 1; i < len; i++) {
            this.sums[i] = this.sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return this.sums[j];
        }
        
        return this.sums[j] - this.sums[i - 1];
    }
}
