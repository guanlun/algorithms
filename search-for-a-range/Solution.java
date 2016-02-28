public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        int [] range = {-1, -1};
        
        while (true) {
            if (left == right) {
                if (nums[left] == target) {
                    range[0] = left;
                    range[1] = right;
                }
                return range;
            }
            
            mid = (left + right) / 2;
            
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int rLeft = left;
        int rRight = mid;
        int rMid;
        
        while (true) {
            if (rLeft == rRight) {
                if (nums[rLeft] == target) {
                    range[0] = rLeft;
                } else { // left less than target
                    range[0] = rLeft + 1;
                }
                break;
            }
            
            rMid = (rLeft + rRight) / 2;
            if (nums[rMid] == target) {
                rRight = rMid;
            } else if (nums[rMid] < target) {
                rLeft = rMid + 1;
            }
        }
        
        rLeft = mid;
        rRight = right;
        
        while (true) {
            if (rLeft == rRight) {
                if (nums[rLeft] == target) {
                    range[1] = rLeft;
                } else { // left greater than target
                    range[1] = rLeft - 1;
                }
                break;
            }
            
            rMid = (rLeft + rRight) / 2;
            if (nums[rMid] == target) {
                rLeft = rMid + 1;
            } else if (nums[rMid] > target) {
                rRight = rMid;
            }
        }
        
        return range;
    }
}