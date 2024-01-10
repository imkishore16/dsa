/*
2385. Amount of Time for Binary Tree to Be Infected
Medium

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

The node is currently uninfected.
The node is adjacent to an infected node.
Return the number of minutes needed for the entire tree to be infected.

 

Example 1:


Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.
Example 2:


Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.
 
 */

// we create an adjacency list for the tree and traverse it.
/*
 the adjacency list would be:

 1 -> [5,3]
 5 -> [1,4]
 3 -> [1,10,6]
 4 -> [5,9,2]
 9 -> [4]
 2 -> [4]
 10 -> [3]
 6 -> [3]

 */


import java.util.*;
class Solution {
    public int amountOfTime(TreeNode root, int start) {

        HashMap<Integer,Set<Integer>> map=new HashMap<>();
        convertTreeToGraph(root,0,map);

        //implement bfs to traverse the map/graph
        Queue<Integer> q=  new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int minutes=0;
        while(!q.isEmpty())
        {
            int levelsize=q.size();
            while(levelsize>0)
            {
                //  q.poll() access the element and remove it from the queue
                int element=q.poll();
                for(int i:map.get(element))
                {
                    if(!visited.contains(i))
                    {
                        visited.add(i);
                        q.add(i);
                    }
                }
                levelsize--;
            }
            minutes++;
        }
        return minutes-1;
    }
    
    // parent  will be initally 0 for the root node
    public static void convertTreeToGraph(TreeNode current,int parent,HashMap<Integer,Set<Integer>> map)
    {
        if(current==null)
            return;
        else
        {
            if(!map.containsKey(current.val))
                map.put(current.val,new HashSet<>());
            
            Set<Integer> adjacencyList = map.get(current.val);

            if(parent!=0)
                adjacencyList.add(parent);
            if(current.left!=null)
                adjacencyList.add(current.left.val);
            if(current.right!=null)
                adjacencyList.add(current.right.val);
            
            //recursive call
            convertTreeToGraph(current.left,current.val,map);
            convertTreeToGraph(current.right,current.val,map);
        }
    }
}