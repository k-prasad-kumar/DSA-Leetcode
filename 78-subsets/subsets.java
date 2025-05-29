class Solution {

    private void solve(int[] nums, List<Integer> output, int index, List<List<Integer>> ans){
        //base case
        if(index >= nums.length){
            ans.add(new ArrayList<>(output));
            return;
        }


        // exclude
        solve(nums, output, index+1, ans);

        //include
        int element = nums[index];
        output.add(element);
        solve(nums, output, index+1, ans);

        // we have to remove elems from output cause its value by reference so in it old elems remians
        output.remove(output.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        int index = 0;
        solve(nums, output, index, ans);

        return ans;
    }
}