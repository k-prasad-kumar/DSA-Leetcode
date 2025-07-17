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
    private int getMin(TreeNode root){
        TreeNode min = root;
        while(min.left != null) min = min.left;

        return min.val;
    }

    private int getMax(TreeNode root){
        TreeNode max = root;
        while(max.right != null) max = max.right;

        return max.val;
    }

    private TreeNode delete(TreeNode root, int k){
        if(root == null) return root;

        if(root.val == k){
            // no child
            if(root.left == null && root.right == null) return null;

            // left  child only
            if(root.left != null && root.right == null) return root.left;

            // right child only
            if(root.left == null && root.right != null) return root.right;

            // 2 child
            if(root.left != null && root.right != null){
                // find max value in left subtree & replace it with root.val
                // int max = getMax(root.left);
                // root.val = max;
                // root.left = delete(root.left, max); // delete max node from right subtree
                // return root;

                // find min value in right subtree & replace it with root.val
                int min = getMin(root.right);
                root.val = min;
                root.right = delete(root.right, min); // delete min node from right subtree
                return root;
            }

        }else if(k < root.val){
            root.left = delete(root.left, k);
        }else{
            root.right = delete(root.right, k);
        }

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
}