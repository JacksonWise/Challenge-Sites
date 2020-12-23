class Solution {
    public boolean isPalindrome(String s) {
        
        if(s.length() <= 1)
            return true;
        
        int leftPos = 0, rightPos = s.length()-1;
		
		while(leftPos < rightPos ) {
            
            // Pass non-alphanumeric characters
			while(!Character.isLetterOrDigit( s.charAt(leftPos)) && leftPos < s.length()-1) {
				leftPos++;
			}
			
			while(!Character.isLetterOrDigit( s.charAt(rightPos)) && rightPos > 0) {
				rightPos--;
			}
                        
            // Just in case all remaining are non-alphanumeric or l/r passed
            if(leftPos > rightPos)
                return true;
			
			// Check if they are equal digits
			if(Character.isDigit(s.charAt(leftPos))){
				if(s.charAt(leftPos) != s.charAt(rightPos))
                    return false;
			}
			
            // Check if they are equal characters
			char lChar = Character.toLowerCase(s.charAt(leftPos));
			char rChar = Character.toLowerCase(s.charAt(rightPos));
			
			if(lChar != rChar)
                return false;
			
			leftPos++;
			rightPos--;
		}
		
		return true;
    }
}