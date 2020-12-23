class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // If there is an empty array, return ""
        if(strs.length == 0)
            return "";
		
		StringBuilder strB = new StringBuilder();
		boolean cont = true;
		int pos = 0; // Next string to check
		
		while(cont == true) {
			
			// Check first string in array, see if within length of next pos
			if(pos == strs[0].length()) {
				return strB.toString();
			}
			
			// Next character to compare
			char nextC = strs[0].charAt(pos);
			
			// Check each string in array
			for(int i = 0; i < strs.length; i++) {
				
				// Check next letter, if within string length
				if( pos == strs[i].length() || strs[i].charAt(pos) != nextC) {
					return strB.toString();
				}
			}
			
			strB.append(nextC);
			pos++;
		}
        
        return strB.toString();
    }
}