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
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        while(left != null){
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }

        while(right != null){
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMid(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = sortList(left);
        right = sortList(right);

        ListNode merged = merge(left, right);

        return merged;

    }
}