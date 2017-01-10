class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        map<int, int> lookup;
        int index = 0;

        for (auto iter = nums.begin(); iter != nums.end(); iter++) {
            int val = *iter;
            int rem = target - val;

            if (lookup.find(rem) != lookup.end()) {
                result.push_back(lookup[rem]);
                result.push_back(index);

                return result;
            }

            lookup.insert({val, index});
            index++;
        }

        return result;
    }
};
