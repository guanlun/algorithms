class Solution {
public:
    void reverseWords(string &s) {
        reverseInRange(s, 0, s.length() - 1);

        int lastPos = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            if (c == ' ') {
                reverseInRange(s, lastPos, i - 1);
                lastPos = i + 1;
            }
        }

        reverseInRange(s, lastPos, s.length() - 1);
    }

private:
    void reverseInRange(string &s, int from, int to) {
        int left = from, right = to;

        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;

            left++;
            right--;
        }
    }
};
