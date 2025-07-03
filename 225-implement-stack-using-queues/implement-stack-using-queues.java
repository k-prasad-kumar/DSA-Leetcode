class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        // move all elems to q2 except last one
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        // get last elem of q1
        int ans = q1.remove();

        //move q2 to q1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

        return ans;
    }
    
    public int top() {
        // move all elems to q2 except last one
        while(q1.size() > 1){
            q2.add(q1.remove());
        }
        // get last elem of q1
        int ans = q1.peek();
        // move last elem of q1 to q2
        q2.add(q1.remove());

        //move q2 to q1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }

        return ans;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */