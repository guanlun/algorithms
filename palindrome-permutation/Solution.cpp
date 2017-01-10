class Solution {
public:
    bool canPermutePalindrome(string s) {
        map<char, int> lookup;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            lookup[c]++;
        }

        int oddCount = 0;

        for (auto c : lookup) {
            if (c.second % 2 == 1) {
                oddCount++;
            }

            if (oddCount > 1) {
                return false;
            }
        }

        return true;
    }
};
