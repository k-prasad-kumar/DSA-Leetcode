class Solution {
    private void swap(int[] nums, int index, int i){
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }

    private void solve(int[] nums, List<List<Integer>> ans, int index){
        if(index >= nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }

            ans.add(list);
            return;
        }

        for(int i=index; i<nums.length; i++){
            swap(nums, index, i);

            solve(nums, ans, index+1);

            swap(nums, index, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0);
        return ans;
    }
}