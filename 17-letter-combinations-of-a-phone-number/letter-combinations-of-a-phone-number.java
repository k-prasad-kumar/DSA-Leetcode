class Solution {
    private void solve(String digits, String output, int index, List<String> ans, String[] keypad){
        // bae case
        if(index >= digits.length()){
            ans.add(output);
            return;
        }

        // getting number for given digits ex - "23" num = '2'
        int num = digits.charAt(index) - '0';
        // getting keypad chars of givien number ex: num=2 val = "abc"
        String val = keypad[num];

        // for loop for val(abc) so we can use recursion for every single char
        for(int i=0; i<val.length(); i++){
            //adding each one char to output string
            output += Character.toString(val.charAt(i));
            // recursion for every single remain chars
            solve(digits, output, index+1, ans, keypad);
            // backtrack/remove last char from output if we dont remove last char it will remain for next iteration
            output = output.substring(0, output.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        // edge case
        if(digits.length() == 0) return ans;

        String keypad[] = {"",".", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        solve(digits, "", 0, ans, keypad);

        return ans;
    }
}