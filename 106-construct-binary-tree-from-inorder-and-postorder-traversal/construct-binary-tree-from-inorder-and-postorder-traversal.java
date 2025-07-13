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
    // global variables
    int postIndex;

    private TreeNode solve(int[] postorder, int start, int end, HashMap<Integer, Integer> nodeToIndex){
        // base case
        if(start > end) return null;

        int element = postorder[postIndex--];  // first get element from postorder arr & decrement postIndex
        TreeNode root = new TreeNode(element);  // create new Node(root) using element 
        int position = nodeToIndex.get(element);    // find position of element in inorder arr mapping

        // create right && left tree RC
        root.right = solve(postorder,  position + 1, end, nodeToIndex);
        root.left = solve(postorder, start, position - 1, nodeToIndex);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        postIndex = n-1;
        // create node -> index mapping to reduce time
        HashMap<Integer, Integer> nodeToIndex = new HashMap<>();
        for(int i=0; i<n; i++) nodeToIndex.put(inorder[i], i);

        return solve(postorder, 0, n-1, nodeToIndex);
    }
}