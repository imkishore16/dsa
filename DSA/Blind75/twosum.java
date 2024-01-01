/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] arr, int target) {
        // using hashset you can find the elements
        /*
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            if(set.isEmpty())
                set.add(arr[i]);
            else
            {
                int rem = target-arr[i];
                if(set.contains(rem))
                    return new int[] {rem,(target-rem)};
                else
                    set.add(arr[i]);
            }
        }
        return new int[]{};

        */

        //using hashmap u can get the indices
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            Integer rem = (Integer)(target - arr[i]);

            if(map.containsKey(rem))
                return new int[]{map.get(rem),i};
            map.put(arr[i],i);
        }
        return null;
        

        // using 2 pointers
        /*
        for(int l=0,r=arr.length-1;l<arr.length && r>=0;)
        {
            int sum = arr[l]+arr[r];
            System.out.println(sum);
            if(sum==target)
                return new int[]{l,r};
            else if(sum > target)
            {
                r--;
            }
            else if(sum < target)
            {
                l++;
            }
        }
        return null;
        */
        
    }
}