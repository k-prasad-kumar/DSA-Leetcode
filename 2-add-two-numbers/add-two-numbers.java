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

    private ListNode sumLinkedList(int val, ListNode head){
        if(head == null){
            ListNode ans = new ListNode(val, null);
            return ans;
        }

        ListNode itr = head;

        while(itr.next != null){
            itr = itr.next;
        }

        itr.next = new ListNode(val, null);

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;

        ListNode itr1 = l1;
        ListNode itr2 = l2;

        int carry = 0;
        while(itr1 != null && itr2 != null){
            int temp = itr1.val + itr2.val + carry;

            if(temp > 9){
                int digit = temp % 10;
                head = sumLinkedList(digit, head);
                carry = temp/10;
            }else{
                head = sumLinkedList(temp, head);
                carry = 0;
            }


           itr1 = itr1.next;
           itr2 = itr2.next;
        }

        // if there is any l1 linkedlist remians
        while(itr1 != null){
            int temp = itr1.val + carry;

            if(temp > 9){
                int digit = temp % 10;
                head = sumLinkedList(digit, head);
                carry = temp/10;
            }else{
                head = sumLinkedList(temp, head);
                carry = 0;
            }

            itr1 = itr1.next;
        }

        // // if there is any l2 linkedlist remians
        while(itr2 != null){
            int temp = itr2.val + carry;

            if(temp > 9){
                int digit = temp % 10;
                head = sumLinkedList(digit, head);
                carry = temp/10;
            }else{
                head = sumLinkedList(temp, head);
                carry = 0;
            }

            itr2 = itr2.next;
        }

        // if carry remains
        if(carry != 0 )  head = sumLinkedList(carry, head);

        return head;

    }
}