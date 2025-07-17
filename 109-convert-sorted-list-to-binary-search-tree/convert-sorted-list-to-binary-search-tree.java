/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private TreeNode buildBST(ListNode start, ListNode end){
        // base case
        if(start == end) return null;

        // find mid between start -> end (note: here check fast with end not with null)
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }

        // create root node
        TreeNode root = new TreeNode(slow.val);

        // create root left subtree from start -> slow (mid) of LL
        root.left = buildBST(start, slow);
        // create root right subtree from slow.next (mid.next) -> end of LL
        root.right = buildBST(slow.next, end);

        return root;
    }

    // 2nd approach (mine)
    private TreeNode buildBST2(ListNode head){
        // base case
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        // find mid
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // create root node
        TreeNode root = new TreeNode(slow.val);
        prev.next = null; // beaking the LL into 2LL

        // create root left subtree from start -> slow (mid) of LL
        root.left = buildBST2(head);
        // create root right subtree from slow.next (mid.next) -> end of LL
        root.right = buildBST2(slow.next);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        // return buildBST(head, null);
        return buildBST2(head);
    }
}