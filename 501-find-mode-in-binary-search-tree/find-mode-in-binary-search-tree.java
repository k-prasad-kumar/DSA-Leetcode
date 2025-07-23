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
    private void inorder(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return;

        inorder(root.left, map);

        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
        }else{
            map.put(root.val, 1);
        }

        inorder(root.right, map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root, map);

        // get max 
        int max = 0;
        for(int i: map.keySet()) if(max < map.get(i)) max = map.get(i);

        // store all max values into arraylist
        List<Integer> al = new ArrayList<>();
        for(int i: map.keySet()){
            if(map.get(i) == max) al.add(i);
        }

        // convert arraylist into array
        int[] arr = new int[al.size()];
        for(int i=0; i<al.size(); i++){
            arr[i] = al.get(i);
        }
        return arr;
    }
}