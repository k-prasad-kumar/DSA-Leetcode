class Solution {
    private int findPosition(int[] nums, int target, boolean findFirstPosition){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;

        while(s<=e){
            int mid = s+(e-s)/2;

            if(nums[mid] == target){
                ans = mid;
                if(findFirstPosition){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }else if(nums[mid] < target){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }

        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
     int[] ans = {-1, -1};

     ans[0] = findPosition(nums, target, true);

     if(ans[0] != -1){
        ans[1] = findPosition(nums, target, false);
     }   

     return ans;
    }
}