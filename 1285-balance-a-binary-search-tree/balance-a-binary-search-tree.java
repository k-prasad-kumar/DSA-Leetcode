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
    private void inorder(TreeNode root, ArrayList<Integer> in){
        if(root == null) return;

        inorder(root.left, in);
        in.add(root.val);
        inorder(root.right, in);
    }

    private TreeNode inorderToBST(ArrayList<Integer> in, int s, int e){
        if(s > e) return null;

        int mid = s + (e-s)/2;
        TreeNode root = new TreeNode(in.get(mid));

        root.left = inorderToBST(in, s, mid-1);
        root.right = inorderToBST(in, mid+1, e);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> in = new ArrayList<>();

        inorder(root, in);

        return inorderToBST(in, 0, in.size()-1);
    }
}