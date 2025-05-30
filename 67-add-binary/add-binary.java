class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        StringBuilder str = new StringBuilder();

        while(i >= 0 || j >= 0 || carry == 1){
            if(i >= 0){
                carry += a.charAt(i--) - '0';
            }

            if(j >= 0){
                carry += b.charAt(j--) - '0';
            }
            
            // if carry 2 (1+1) then it will append 0
            str.append(carry % 2);
            
            // if carry had two digit then carry = carry/2
            carry /= 2; 
        }

        return str.reverse().toString();
    }
}