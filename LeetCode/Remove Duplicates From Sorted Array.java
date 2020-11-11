class Solution {
    public int removeDuplicates(int[] nums) {
        
        // Just in case we're passed an array with 0 or 1 elements
        if( nums.length <= 1 )
            return nums.length;
        
        int uniques = 1;
        
        // next unique element position in array
        int leftNum = 1;
        
        // 
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    
                    // Add next unique element to return array
                    nums[leftNum] = nums[j];
                    uniques++;
                    leftNum++;
                    
                    // Continue at right position (i incremented in loop)
                    i = j-1;
                    break;
                }
            }
        }
        
        return uniques;
    }
}