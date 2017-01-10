class Solution {
public:
    bool isValid(string s) {
        vector<char> stack;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];

            if (isClosing(c)) {
                if (stack.size() == 0) {
                    return false;
                }

                char last = stack.back();

                stack.pop_back();

                if ((c == '}' && last != '{') || (c == ']' && last != '[') || (c == ')' && last != '(')) {
                    return false;
                }
            } else {
                stack.push_back(c);
            }
        }

        return (stack.size() == 0);
    }

private:
    bool isClosing(char c) {
        return (c == ']') || (c == ')') || (c == '}');
    }
};
