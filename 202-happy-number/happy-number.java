class Solution {
    // public int squareOfNum(int n){
    //     ArrayList<Integer> nums = new ArrayList<>();

    //     while(n != 0){
    //         int digit = n%10;
    //         nums.add(digit);
    //         n = n/10;
    //     }
    //     int ans = 0;
    //     for(int num: nums){
    //         ans += num*num;
    //     }

    //     return ans;
    // }

    public boolean isHappy(int n) {

        // int slow = n;
        // int fast = n;
        // do{
        //     slow = squareOfNum(slow);
        //     fast = squareOfNum(squareOfNum(fast));
        // }while(slow != fast);

        // return slow == 1 || slow == 7;
        int sum = 0, rem;
        while(n > 9){
            while(n!=0)
            {
                rem = n % 10;
                sum += rem * rem;
                n /= 10; 
            }
            n = sum; sum = 0;
        }
        return n == 1 || n == 7;
    }
}