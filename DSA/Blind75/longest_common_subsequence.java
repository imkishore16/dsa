/*
1143. Longest Common Subsequence
Medium


Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 
 */
import java.util.*;

 class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],0);
        
        for(int i=m-1;i>=0;i--)
        {            
            for(int j=n-1;j>=0;j--)
            {
                if(text1.charAt(i)==text2.charAt(j))  // if the characters match we will move diagonally 
                    dp[i][j]=1+ dp[i+1][j+1];
                else
                   dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]); //else put the last largest number
            }
        }
       return dp[0][0];
    }
}