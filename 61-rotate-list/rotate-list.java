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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        
        ListNode itr = head;
        int length = 1;
        while(itr.next != null){
            itr = itr.next;
            length++;
        }

        // calculate actual no of shifts to make
        k = k % length;
        // check edgecase for no shift
        if(k == 0 || k == length) return head;
        
        // make it cycle
        itr.next = head;
       
        ListNode curr = head;
        length -= k;
        while(length-1 > 0){
            curr = curr.next;
            length--;
        }
        head = curr.next;
        curr.next = null;

        return head;
    }
}