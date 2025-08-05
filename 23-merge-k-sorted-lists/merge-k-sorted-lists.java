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

        if(k == 0) return null;

        for(int i=0; i<k; i++) {
            if(lists[i] != null) minHeap.add(lists[i]);
        }
        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()){
            ListNode top = minHeap.remove();

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