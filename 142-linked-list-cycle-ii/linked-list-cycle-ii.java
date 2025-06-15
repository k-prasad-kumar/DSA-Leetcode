/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // find intersection of cycle
        ListNode intersection = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // if(fast != null) fast = fast.next;

            if(slow == fast ) {
                intersection = slow;
                break;
            }
        }
        // checking is cycle exist or not
        if(intersection == null) return intersection;

        slow = head;
        while(slow != intersection){
            slow = slow.next;
            intersection = intersection.next;
        }

        return slow;
    }
}