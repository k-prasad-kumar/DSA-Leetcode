class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        // move st1 to st2
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        // pop from st2
        int val = st2.pop();
        // move remaining elems to st1
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return val;
    }
    
    public int peek() {
        // move st1 to st2
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        // pop from st2
        int val = st2.peek();
        // move remaining elems to st1
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return val;
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */