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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean isReverse = false;

        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> arr = new LinkedList<>();

            for(int i=0; i<size; i++){
                TreeNode t = q.remove();

                if (isReverse)
                    arr.addFirst(t.val);
                else
                    arr.addLast(t.val);

                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            isReverse = !isReverse;
            ans.add(arr);
        }

        return ans;
    }
}