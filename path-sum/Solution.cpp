/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        return helper(root, sum);
    }

private:
    bool helper(TreeNode* curr, int rem) {
        if (!curr) {
            return false;
        }

        int newRem = rem - curr->val;

        if (!curr->left && !curr->right) {
            return (newRem == 0);
        }

        bool leftRes = false, rightRes = false;

        if (curr->left) {
            leftRes = helper(curr->left, newRem);
        }

        if (curr->right) {
            rightRes = helper(curr->right, newRem);
        }

        return leftRes || rightRes;
    }
};
