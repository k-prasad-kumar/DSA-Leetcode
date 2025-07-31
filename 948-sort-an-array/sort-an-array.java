class Solution {
    // 0 - based indexing max heapify
    private void maxHeapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[largest] < arr[left]) largest = left;
        if(right < n && arr[largest] < arr[right]) largest = right;

        // if largest changed means found largest elem
        if(largest != i){
            // swap i & largest
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // max heapify from largest
            maxHeapify(arr, n, largest);
        }

    }
    private void heapSort(int[] arr, int n){
        int size = n;
        
        while(size > 0){
            // swap 0 & size-1
            int temp = arr[0];
            arr[0] = arr[size-1];
            arr[size-1] = temp;
            size--;
            
            // max heapify
            maxHeapify(arr, size, 0);
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        // step 1: max heapify given array
        for(int i=n/2-1; i>=0; i--) maxHeapify(nums, n, i);
        // step2: sort array uing heapsort
        heapSort(nums, n);

        return nums;
    }
}