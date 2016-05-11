public class Solution {
    public int trap(int[] height) {
        int length = height.length;
        
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        
        int currLeftMax = 0;
        int currRightMax = 0;
        
        int totalWater = 0;
        
        for (int i = 0; i < length; i++) {
            leftMax[i] = currLeftMax;
            
            if (height[i] > currLeftMax) {
                currLeftMax = height[i];
            }
        }
        
        for (int i = length - 1; i >= 0; i--) {
            rightMax[i] = currRightMax;
            
            if (height[i] > currRightMax) {
                currRightMax = height[i];
            }
        }
        
        for (int i = 0; i < length; i++) {
            int depth = Math.min(leftMax[i], rightMax[i]) - height[i];
            
            if (depth > 0) {
                totalWater += depth;
            }
        }
        
        return totalWater;
    }
}
