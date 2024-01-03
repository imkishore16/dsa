/*
300. Longest Increasing Subsequence
Medium

Given an integer array nums, return the length of the longest strictly increasing 
subsequence

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        // for(int i=n-1;i>=0;i--)
        // {
        //     for(int j=i+1;j<n;j++)
        //     {
        //         if(nums[i]<nums[j])
        //             dp[i]=Math.max(dp[i],1+dp[j]);
        //     }
        // }
        for(int i=0;i<n;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
        }

        int max=0;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>max)
                max=dp[i];
        }
        return max;

    }
}