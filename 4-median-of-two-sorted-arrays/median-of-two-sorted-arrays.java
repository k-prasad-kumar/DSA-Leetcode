class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int i = 0;
        int j = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        
        while(i < len1 && j < len2){
            if(nums1[i] <= nums2[j]){
                arr.add(nums1[i++]);
            }else{
                arr.add(nums2[j++]);
            }
        }
        
        while(i < len1) arr.add(nums1[i++]);
        while(j < len2) arr.add(nums2[j++]);
                
        int arrLen = arr.size();
        double ans;
        if(arrLen % 2 != 0){
            int mid = (0+arrLen)/2;
            ans = (double) arr.get(mid);
        }else{
            int mid = (0+arrLen)/2;
            ans = (double) (arr.get(mid) + arr.get(mid-1)) / 2.0;
        }

        return ans;
    }
}