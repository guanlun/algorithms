public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        int[] result = {-1, -1};

        int left = 0;
        int right = len - 1;
        int mid = 0;

        int occurrence = -1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                occurrence = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (occurrence == -1) {
            return result;
        }

        // Find the beginning index
        left = 0;
        right = occurrence;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        result[0] = (nums[mid] == target) ? mid : mid + 1;

        // Find the ending index
        left = occurrence;
        right = len - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        result[1] = (nums[mid] == target) ? mid : mid - 1;

        return result;
    }
}
