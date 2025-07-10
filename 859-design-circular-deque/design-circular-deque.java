class MyCircularDeque {
    int[] q;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        q = new int[k];
        front = -1;
        rear = -1;
        size = 0;
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;

        if(isEmpty()) front = rear = 0;
        else if(front == 0) front = capacity-1;
        else front--;

        q[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        
        if(isEmpty()) front = rear = 0;
        else if(rear == capacity - 1) rear = 0;
        else rear++;

        q[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;

        q[front] = -1;

        if(front == capacity-1) front = 0;
        else front++;
        
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;

        q[rear] = -1;

        if(rear == 0) rear = capacity-1;
        else rear--;

        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;

        return q[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;

        return q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */