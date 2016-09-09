public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) {
            return results;
        }

        for (int i = 0; i < len - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }

            int elem1 = nums[i];

            int left = i + 1;
            int right = len - 1;

            while (left < right) {
                int sum = elem1 + nums[left] + nums[right];

                if (sum == 0) {
                    ArrayList<Integer> result = new ArrayList<Integer>();
                    result.add(elem1);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    results.add(result);

                    while (left + 1 < right && nums[left + 1] == nums[left]) {
                        left++;
                    }

                    while (right - 1 > left && nums[right - 1] == nums[right]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return results;
    }
}
