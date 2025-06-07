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
    // public void reverse(ListNode curr, int right){
    //     // ListNode itr = curr;
    //      ListNode prev = null;
    //      ListNode next = null;
    //      ListNode temp = null;
    //     // reverse
    //     while(curr.val != right){
    //         next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     // temp.next = prev;

    // }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if(head == null) return null;

        // cereated dummy LL 
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // get pre node of left
        ListNode prev = dummy;
        for(int i=0; i<left-1; i++) prev = prev.next;

        ListNode curr = prev.next;
        ListNode next = curr.next;

        for(int j=0; j<right-left; j++){
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }

        return dummy.next;
    }
}