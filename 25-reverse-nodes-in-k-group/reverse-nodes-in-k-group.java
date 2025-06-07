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
class Solution {
    public static int getLength(ListNode head){
        ListNode itr = head;
        int count = 0;

        while(itr != null){
            itr = itr.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        if(head == null) return null;

        // get length to know how many nodes left unreversed
        int n = getLength(head);

        // reverse 1st k nodes of LL
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        int count = 0;
        while(curr != null && count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // check how many remaining & reverse remaining LL using RC if any remain
        if(next != null && n-k >= k){
            head.next = reverseKGroup(next, k);
        }else {
            head.next = curr;
        }
        return prev;
    }
}