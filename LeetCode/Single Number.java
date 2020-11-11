class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i += 2){
            
            // Find the pair which doesn't match
            if( nums[i] != nums[i+1]){
                
                // First number in pair doesn't match
                if(nums[i+1] == nums[i+2])
                    return nums[i];
                
                // Second number in pair doesn't match
                return nums[i+1];
            }
        }
        
        //The very last number didn't match
        return nums[nums.length-1];
    }
}