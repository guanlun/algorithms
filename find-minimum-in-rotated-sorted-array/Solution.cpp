class Solution {
public:
    int findMin(vector<int>& nums) {
        int len = nums.size();

        if (len == 0) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

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
};
