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
    int i = 0;
    int ans = -1;

    private int solve(TreeNode root, int k){
        if(root == null) return ans;

        solve(root.left, k);

        i++;
        if(i == k) return ans = root.val;

        solve(root.right, k);

        return ans;
    }

    public int kthSmallest(TreeNode root, int k) {
        i = 0;
        return solve(root, k);
    }
}