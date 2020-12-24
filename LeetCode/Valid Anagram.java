class Solution {
    public boolean isAnagram(String s, String t) {
        
        if( s.length() != t.length() )
			return false;
		
		HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();
		
		// Add s String characters to HashMap
		for(int i = 0; i < s.length(); i++) {
			
			char nextC = s.charAt(i);
			
			if( mapS.containsKey(nextC))
				mapS.put(nextC, mapS.get(nextC) + 1);
			else
				mapS.put(nextC, 1);
		}
		
		// Remove t chars from HashMap
		for(int i = 0; i < t.length(); i++) {
			
			char nextC = t.charAt(i);
			
			// A char in t isn't in s
			if( !mapS.containsKey(nextC))
				return false;
			
			int charCount = mapS.get(nextC) - 1;
			
			if( charCount < 0 )
				return false;
			else {
				mapS.put(nextC, charCount);
			}
		}
        
        return true;
    }
}