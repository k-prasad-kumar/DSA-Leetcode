class Solution {
    private int binarySearch(int[] nums, int target, boolean findFirstPosition){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid] == target){
                ans = mid;
                if(findFirstPosition){ // if findFirstPosition true it will try to find first position
                    e = mid-1;
                }else{      // if findFirstPosition false it will try to find last position
                    s = mid+1;
                }

            }else if(nums[mid] < target) {
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};

        // find 1st position of target (here isIndex true means it will try to find first position)
        ans[0] = binarySearch(nums, target, true);

        // check if target found, if fount then try to find last position
        if(ans[0] != -1){
            ans[1] = binarySearch(nums, target, false);
        }
        
        return ans;
    }
}