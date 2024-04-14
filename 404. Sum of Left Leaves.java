/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);

        return result;
    }

    public void helper(TreeNode node, boolean isLeft)
    {
        if(node.left != null)
        {
            helper(node.left, true);
        }
        else
        {
            if(isLeft && node.right == null)
            {
                result += node.val;
            }
        }

        if(node.right != null)
        {
            helper(node.right, false);
        }
    }
}