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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);

        int k = lists.length;
        // if there is no linkedlist return null
        if(k == 0) return null;

        // insert every linkedlist head into min heap
        for(int i=0; i<k; i++) {
            if(lists[i] != null) minHeap.add(lists[i]);
        }

        // make merged Linkedlist
        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.remove();

            // if top had next node then insert it into min heap
            if(top.next != null) minHeap.add(top.next);

            if(head == null){
                head = tail = top;
            }else{
                tail.next = top;
                tail = top;
            }
        }

        return head;
    }
}