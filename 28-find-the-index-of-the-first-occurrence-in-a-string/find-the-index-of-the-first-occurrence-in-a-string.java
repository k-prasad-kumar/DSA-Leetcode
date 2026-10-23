class Solution {
    public boolean isStrOccur(String haystack, String needle, int i){
        if(haystack.length()-i < needle.length()) return false;

        int j=0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i++) != needle.charAt(j++)) return false;
        }   

        return true;
    }
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        for(int i=0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(isStrOccur(haystack, needle, i)) return i;
            }
        }

        return -1;
    }
}