/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.HashMap;
class Solution {
    public Node cloneLinkedList(Node head){
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node itr = head;
        while(itr != null){
            curr.next = new Node(itr.val);
            curr = curr.next;
            itr = itr.next;
        }

        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        if(head ==  null) return head;
        // create CloneLL
        Node clone = cloneLinkedList(head);

        // map
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Node originalLL = head;
        Node cloneLL = clone;

        while(originalLL != null){
            oldToNew.put(originalLL, cloneLL);
            originalLL = originalLL.next;
            cloneLL = cloneLL.next;
        }

        // add random to cloneLL
        originalLL = head;
        cloneLL = clone;

        while(originalLL != null){
            if(originalLL.random != null) cloneLL.random = oldToNew.get(originalLL.random);

            originalLL = originalLL.next;
            cloneLL = cloneLL.next;
        }

        return clone;

    }
}