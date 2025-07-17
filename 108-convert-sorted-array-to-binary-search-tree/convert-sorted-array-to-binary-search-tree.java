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
    private TreeNode buildBST(int[] nums, int start, int end){
        //base case
        if(start > end) return null;

        // find mis & create node
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // create root left subtree from start -> mid - 1 
        root.left = buildBST(nums, start, mid-1);
        // create root right subtree from mid + 1 -> end 
        root.right = buildBST(nums, mid+1, end);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
}