public class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];

            } else if (nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                left = mid + 1;

            } else {
                right = mid;

            }
        }

        return 0;
    }
}
