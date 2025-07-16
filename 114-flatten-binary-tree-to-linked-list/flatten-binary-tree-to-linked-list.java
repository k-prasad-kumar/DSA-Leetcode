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

        // using RC
        // // first traverse right cause right side last node is the last node of the faltten LL
        // flatten(root.right);
        // flatten(root.left);

        // // when we backtrack we add prev node as curr node's right & null as left
        // root.right = prev;
        // root.left = null;
        // prev = root;

        // using Morris Traversal
        TreeNode curr = root;

        while(curr != null){
             // If left child is not null
            if(curr.left != null){
                // Find the inorder predecessor of curr
                TreeNode prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                // point predecessor right to curr right (curr is root first time)
                // poit curr right to curr left
                // point curr left to null
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            // traverse untill curr left is null 
            // it will reach end node so loop will break
            curr = curr.right;
        }
    }
}