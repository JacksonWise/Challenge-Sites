class Solution {
    public void moveZeroes(int[] nums) {
        
        // Next position to write;
        int left = 0;
        
        for(int i = 0; i < nums.length-1; i++){
            
            // Find next zero element
            if(nums[i] != 0){
                left++;
                continue;
            }
            
            // Find next non-zero element
            for(int k = i+1; k < nums.length; k++){
                if(nums[k] != 0){
                    nums[left] = nums[k];
                    left++;
                    nums[k] = 0;
                    i = k-1;
                    break;
                }
            }
        }
    }
}