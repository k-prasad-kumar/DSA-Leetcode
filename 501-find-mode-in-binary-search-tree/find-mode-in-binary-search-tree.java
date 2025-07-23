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
        // if(map.containsKey(root.val)){
        //     map.put(root.val, map.get(root.val)+1);
        // }else{
        //     map.put(root.val, 1);
        // }

        if(prev != null && prev.val == root.val){
            currentCount++;
        }else{
            currentCount = 1;
        }
        
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes = new ArrayList<>();
            modes.add(root.val);
        } else if (currentCount == maxCount) {
            modes.add(root.val);
        }

        prev = root;

        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // inorder(root, map);

        // // get max 
        // int max = 0;
        // for(int i: map.keySet()) if(max < map.get(i)) max = map.get(i);

        // // store all max values into arraylist
        // List<Integer> al = new ArrayList<>();
        // for(int i: map.keySet()){
        //     if(map.get(i) == max) al.add(i);
        // }

        
        inorder(root);

        // convert arraylist into array
        int[] arr = new int[modes.size()];
        for(int i=0; i<modes.size(); i++){
            arr[i] = modes.get(i);
        }
        return arr;
    }
}