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

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        // swap every node childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left); // invert left side
        invertTree(root.right); // invert right side

        return root;
    }
}