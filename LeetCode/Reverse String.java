class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        
        for( ; l < r; ){
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            l++;
            r--;
        }
    }
}