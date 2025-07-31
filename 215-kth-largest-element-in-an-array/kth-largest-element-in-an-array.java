class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // // step 1: add all arr elems to pq
        // for(int num: nums) pq.add(num);

        // // remove pq top k times
        // while(pq.size() > k) pq.remove();

        // // return pq top which is ans
        // return pq.peek();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if(i < k) {
                pq.add(nums[i]);
            } else {
                if(nums[i] > pq.peek()) {
                    pq.remove();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}