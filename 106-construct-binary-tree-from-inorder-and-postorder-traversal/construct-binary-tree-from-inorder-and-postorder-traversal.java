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
    // global var
    int postIndex;
    
    private TreeNode solve(int[] postorder, int start, int end, HashMap<Integer, Integer> nodeToIndex){
        if(start > end) return null;

        // create root noe
        int element = postorder[postIndex--];
        TreeNode root = new TreeNode(element);
        int position = nodeToIndex.get(element);

        root.right = solve(postorder,  position + 1, end, nodeToIndex);
        root.left = solve(postorder, start, position - 1, nodeToIndex);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        postIndex = n-1;
        HashMap<Integer, Integer> nodeToIndex = new HashMap<>();
        for(int i=0; i<n; i++) nodeToIndex.put(inorder[i], i);

        return solve(postorder, 0, n-1, nodeToIndex);
    }
}