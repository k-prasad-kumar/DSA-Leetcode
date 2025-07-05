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
    class TreeInfo{ // custom pair class
        int diam;
        int height;
        
        TreeInfo(int diam, int height){
            this.diam = diam;
            this.height = height;
        }
    }

    private TreeInfo diamOfTree(TreeNode root){
        if(root == null) return new TreeInfo(0, 0);

        TreeInfo left = diamOfTree(root.left);
        TreeInfo right = diamOfTree(root.right);

        int leftDiam = left.diam;
        int rightDiam = right.diam;
        int totalHeight = left.height + right.height;

        int newDiam = Math.max(totalHeight, Math.max(leftDiam, rightDiam));
        int newHeight = Math.max(left.height, right.height) + 1;

        return new TreeInfo(newDiam, newHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return diamOfTree(root).diam;
    }
}