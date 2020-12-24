class Solution {
    public int strStr(String haystack, String needle) {
        
        // In case there's no needle, return 0
        if( needle.compareTo("") == 0 ) {
			return 0;
		}
        
        int needLen = needle.length();
		int hayLen = haystack.length();
		int lenDiff = hayLen - needLen + 1;
        
        // Needle larger than haystack
        if( needLen > hayLen ) {
			return -1;
		}
        
        for(int i = 0; i < lenDiff; i++ ) {
            // Skip if first characters don't match
			if( haystack.charAt(i) !=  needle.charAt(0))
				continue;
			
			String checkSub = haystack.substring(i, i+needLen);
			
			if( checkSub.compareTo(needle) == 0)
				return i;
		}
        
        // Needle not found
        return -1;
    }
}