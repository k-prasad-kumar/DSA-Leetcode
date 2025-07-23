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
    List<Integer> modes = new ArrayList<>();
    TreeNode prev = null;
    int currentCount = 0;
    int maxCount = 0;

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && prev.val == root.val){ // when prev val is equal to curr root val increase count
            currentCount++;
        }else{
            currentCount = 1;
        }
        // check currentCount is greater than maxCount then change maxCount and create new modes arraylist
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes = new ArrayList<>(); // when we get new max occured value we create a new arraylist
            modes.add(root.val);
        } else if (currentCount == maxCount) {
            modes.add(root.val);
        }

        prev = root; // for next round curr node is prev node

        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        // optimal approach
        inorder(root);

        // convert arraylist into array
        int[] arr = new int[modes.size()];
        for(int i=0; i<modes.size(); i++){
            arr[i] = modes.get(i);
        }

        return arr;
    }
}