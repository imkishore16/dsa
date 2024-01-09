class Solution {
    int n=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else
        {
            int l=maxDepth(root.left);
            int r=maxDepth(root.right);
            return Math.max(l,r)+1;
        }
    }
}