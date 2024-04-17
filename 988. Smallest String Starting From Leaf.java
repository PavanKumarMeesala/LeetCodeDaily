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
    String result = "";
    public String smallestFromLeaf(TreeNode root) {
        helper(root, new StringBuilder());

        return result;
    }

    public void helper(TreeNode node, StringBuilder path)
    {
        if(node == null) return;
        char ch = (char) ('a' + node.val); 

        path.insert(0, ch);
        if(node.left == null && node.right == null)
        {
            if(result.compareTo(path.toString()) > 0 || result.length() == 0)
            {
                result = path.toString();
            }
        }

        if(node.left != null)
        {
            helper(node.left, path);
        }

        if(node.right != null)
        {
            helper(node.right, path);
        }

        path.deleteCharAt(0);
    }
}