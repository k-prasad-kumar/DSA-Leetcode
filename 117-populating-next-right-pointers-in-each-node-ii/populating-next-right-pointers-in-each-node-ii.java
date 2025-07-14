/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        List<Node> currLevel = new ArrayList<>();
        currLevel.add(root);

        while(!currLevel.isEmpty()){
            int size = currLevel.size();
            List<Node> nextLevel = new ArrayList<>();

            for(int i=0; i<size; i++){
                Node temp = currLevel.get(i);
                if(temp == null) continue;

                if(i < size-1) temp.next = currLevel.get(i+1);

                if(temp.left != null) nextLevel.add(temp.left);
                if(temp.right != null) nextLevel.add(temp.right);
            }
            currLevel = nextLevel;
        }
        return root;
    }
}