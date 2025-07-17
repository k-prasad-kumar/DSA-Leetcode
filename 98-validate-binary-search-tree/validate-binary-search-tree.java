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
    private boolean isValid(TreeNode root, long min, long max){
        // base case
        if(root == null) return true;

        // checking curr node in range (root should be greater than min && smaller than max)
        if(root.val >= max || root.val <= min) return false;

        // range of left is min -> root && range of right is root -> max
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}