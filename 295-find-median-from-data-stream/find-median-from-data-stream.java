class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    }

    private void balance() {
        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();  // balancing both heaps (left & right)
    }
    
    public double findMedian() {
        int a = minHeap.size();
        int b = maxHeap.size();
        if (a == b) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if (a < b) {
                return (double)maxHeap.peek();
            } else {
                return (double)minHeap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */