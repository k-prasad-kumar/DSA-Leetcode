class Solution {
    public String defangIPaddr(String address) {
        String ans = "";
        
        for(char ch: address.toCharArray()){
            // checking is it . char or not using ternary method
            ans += ch == '.' ? "[.]" : String.valueOf(ch);
        }

        return ans;
    }
}