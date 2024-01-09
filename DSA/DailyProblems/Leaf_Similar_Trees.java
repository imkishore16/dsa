/*
872. Leaf-Similar Trees
Easy

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:

Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
Example 2:


Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 */

package DSA.DailyProblems;

import java.util.*;
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafvalues1= new ArrayList<>();
        ArrayList<Integer> leafvalues2= new ArrayList<>();
        dfs(root1,leafvalues1);
        dfs(root2,leafvalues2);

        return leafvalues1.equals(leafvalues2);
    }

    public void dfs(TreeNode root,List<Integer> leafvalues)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            leafvalues.add(root.val);
        dfs(root.left,leafvalues);
        dfs(root.right,leafvalues);
    }
}