/*
322. Coin Change
Medium

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */


import java.util.*;
//sum very similar to combinationSum4
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        // each index in the amount array will represent the the amount
        //ie amount[2] means coins required to get total 2
        //ie amount[8] means coins required to get total 8
        Arrays.fill(dp,amount+1); // full array is filled with amount+1
        dp[0]=0;  //base case

        for(int i=1;i<=amount;i++)
            for(int j:coins)
            {
                if(i>=coins[j])
                {
                    dp[i]=Math.min(dp[i],1+dp[i-j]);
                }
            }
        // for(int i=1;i<=amount;i++)
        //     for(int j=0;j<coins.length;j++)
        //     {
        //         if(i>=coins[j])
        //         {
        //             dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
        //         }
        //     }
        if(dp[amount]<=amount)
            return dp[amount];
        else
            return -1;
    }
}