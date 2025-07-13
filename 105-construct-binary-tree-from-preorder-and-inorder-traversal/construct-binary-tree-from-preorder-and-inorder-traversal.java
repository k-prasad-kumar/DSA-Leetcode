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
    private int preorderIndex;
    private Map<Integer, Integer> mapping;

    private TreeNode build(int[] preorder, int start, int end) {
        // base case
        if (start > end) return null;

        int rootVal = preorder[preorderIndex++];  // first get element from preOrder arr
        TreeNode root = new TreeNode(rootVal);  // create new Node(root) using element 
        int mid = mapping.get(rootVal);   // find position of element in inorder arr

        // create left & right tree RC
        root.left = build(preorder, start, mid - 1);
        root.right = build(preorder, mid + 1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        mapping = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapping.put(inorder[i], i);
        }

        preorderIndex = 0;
        return build(preorder, 0, n - 1);
    }
}