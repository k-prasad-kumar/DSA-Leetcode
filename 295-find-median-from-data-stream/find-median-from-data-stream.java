class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min Heap (default)
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap using reverse order
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());

        if(minHeap.size() > maxHeap.size()) maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
       if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
    
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */