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
    private boolean solve(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p != null && q == null) return false;
        if(p == null && q != null) return false;

        boolean left = solve(p.left, q.left);
        boolean right = solve(p.right, q.right);

        boolean curr = p.val == q.val;

        if(left && right && curr) return true;
        else return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p,q);
    }
}