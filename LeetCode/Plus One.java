class Solution {
    public int[] plusOne(int[] digits) {
        
        // Add 1 to right-most digit, carry over if needed
        for(int i = digits.length-1; i >= 0; i--){
            digits[i] = (digits[i] + 1) % 10;
            
            // Digit was less than 9, all done
            if(digits[i] != 0)
                return digits;
        }
        
        // Input array was all 9's
        // Return 1-digit longer array with leading 1 and trailing 0's
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;   
    }
}