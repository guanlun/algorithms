class Solution {
public:
    int longestPalindrome(string s) {
        map<char, int> lookup;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            lookup[c]++;
        }

        int totalLen = 0;
        bool hasOdd = false;

        for (auto pair : lookup) {
            int count = pair.second;
            totalLen += count >> 1 << 1;

            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        if (hasOdd) {
            totalLen++;
        }

        return totalLen;
    }
};
