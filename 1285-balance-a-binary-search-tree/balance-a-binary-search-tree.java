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
    public void inorder(TreeNode root, ArrayList<Integer> in){
        if(root == null) return;

        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }

    public TreeNode binaryBST(int s, int e, ArrayList<Integer> in){
        if(s > e) return null;

        int mid = s + (e-s)/2;
        TreeNode root = new TreeNode(in.get(mid));

        root.left = binaryBST(s, mid-1, in);
        root.right = binaryBST(mid+1, e, in);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> in = new ArrayList<>();

        inorder(root, in);

        return binaryBST(0, in.size()-1, in);
    }
}