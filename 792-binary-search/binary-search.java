class Solution {
    static int binarySearch(int arr[], int k, int s, int e){
        if(s > e) return -1;
        
        int mid  = s + (e-s)/2;
        
        if(arr[mid] == k) return mid;
        
        if(arr[mid] > k) return binarySearch(arr, k, s, mid-1);
        else return binarySearch(arr, k, mid+1, e);
    }

    public int search(int[] nums, int target) {
        
        return binarySearch(nums, target, 0, nums.length-1);
    }
}