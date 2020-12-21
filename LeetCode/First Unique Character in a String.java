class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>(); 
        
        // Place characters into a HashMap
		for(int i = 0; i < s.length(); i++) {
			
			char check = s.charAt(i);
			
			// More than one occurrence
			if( map.containsKey(check) ) {
				map.put(check, 2);
			}
			
			// First occurrence of letter
			else {
				map.put(check, 1);
			}
		}
        
        // Check for first unique character
		for(int i = 0; i < s.length(); i++) {
			
			char check = s.charAt(i);
			
			if(map.get(check) == 1) {
				return i;
			}
		}
        
        // No solution
        return -1;
    }
}