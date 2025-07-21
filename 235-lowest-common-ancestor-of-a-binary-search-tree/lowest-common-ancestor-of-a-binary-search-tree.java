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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // using recursive approach
        // if(root == null) return null;

        // if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        // if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p , q);

        // using iterative approach
        while(root != null){
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }

        return root;
    }
}