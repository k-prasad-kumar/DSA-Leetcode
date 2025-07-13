/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        // if found return it
        if(p == root || q == root) return root;
        // find p & q nodes
        TreeNode leftAns = solve(root.left, p, q);
        TreeNode rightAns = solve(root.right, p, q);
        // check weather both nodes ancestor equal if it return root
        if(leftAns != null && rightAns != null) return root;
        // check weather one is not null (p/q node) if it return that node
        else if(leftAns != null && rightAns == null) return leftAns;
        else if(leftAns == null && rightAns != null) return rightAns;
        // if both equals to null means not found p&q
        else return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }
}