/*
39. Word Break
Medium

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 
 */
import java.util.*;

 class Solution {
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     int pointer=0;
    //     while(pointer<=s.length())
    //     {
    //         for(int i=0;i<wordDict.size();i++)
    //         {
    //             String x=wordDict.get(i);
    //             if(pointer+x.length()<=s.length() && x.equals(s.substring(pointer,pointer+x.length())));
    //                 pointer=pointer+x.length();
    //         }

    //     }
    //     System.out.println(pointer+" "+s.length());
    //         if(pointer==s.length()) 
    //             return true;
    //         else
    //             return false;
    // }


    // public boolean wordBreak(String s, List<String> wordDict) {
        
    //     int n= s.length();
    //     boolean dp[] = new boolean[n+1];
    //     Arrays.fill(dp,false);
    //     dp[n]=true;  

    //     for(int i=n-1;i>=0;i--)
    //     {
    //         for(String word:wordDict)
    //         {
    //             if(i+word.length()<=s.length() && word.equals(s.substring(i,i+word.length())))
    //                 dp[i]=dp[i+word.length()];
    //             if(dp[i])
    //                 break;
    //         }
    //     }
    //     return dp[0];
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n= s.length();
        boolean dp[] = new boolean[n+1];
        Arrays.fill(dp,false);
        dp[0]=true;  
        Set<String> wordSet=new HashSet<>(wordDict);

        for(int i=1;i<=s.length();i++) // travversing the string
        {
            for(int j=0;j<i;j++) //traversing the substring
            {
                if(dp[j] && wordSet.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}