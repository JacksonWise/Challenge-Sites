class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        Arrays.sort(nums);
        
        for( int checkNum = 0; checkNum < nums.length-1; checkNum++){
            if(nums[checkNum] == nums[checkNum+1])
                return true;
        }    
        
        // No duplicates found
        return false;
    }
}