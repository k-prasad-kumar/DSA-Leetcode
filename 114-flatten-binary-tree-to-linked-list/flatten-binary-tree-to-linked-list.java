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
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // first traverse right cause right side last node is the last node of the faltten LL
        flatten(root.right);
        flatten(root.left);

        // when we backtrack we add curr node as prev node's right & null as left
        root.right = prev;
        root.left = null;
        prev = root;
    }
}