class Solution {
    public void rotate(int[] nums, int k) {
        int numsLen = nums.length;
        
        // In case rotation amount is larger than array size
        k = k % numsLen;
        
        // Make a new array with shifted elements
        int[] newNums = new int[numsLen];
        
        for(int i = 0; i < numsLen; i++){
            newNums[ (k + i) % numsLen ] = nums[i];
        }
        
        // Copy shifted array to original array
        for(int i = 0; i < numsLen; i++){
            nums[i] = newNums[i];
        }
    }
}