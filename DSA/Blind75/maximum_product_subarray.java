/*
 152. Maximum Product Subarray
Medium

Companies
Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

class Solution {
    public int maxProduct(int[] nums) {
        // Dynamic programming using 2 pointers
        if(nums.length==0)
            return 0;

        int min=nums[0];
        int max=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int curr=nums[i];
            int temp=Math.max(curr,Math.max(curr*min,curr*max));
            min=Math.min(curr,Math.min(curr*min,curr*max));
            max=temp;
            result=Math.max(result,max);
        }
        return result;
    }
}