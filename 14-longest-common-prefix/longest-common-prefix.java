class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";

        if(strs.length == 0) return ans;

        for(int i=0; i<strs[0].length(); i++){
            char ch = strs[0].charAt(i);
            boolean match = true;

            for(int j=1; j<strs.length; j++){
                if(strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    match = false;
                    break;
                }
            }

            if(match == true) ans += "" + ch;
            else break;
        }

        return ans;
    }
}