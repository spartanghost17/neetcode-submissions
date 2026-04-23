/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if(root == null) return 0;
        
        int good = root.val >= max ? 1 : 0;
        int currMax = Math.max(max, root.val);
        return good += dfs(root.left, currMax) + dfs(root.right, currMax); 
    }

    // public int goodNodes(TreeNode root) {
    //     int[] res = {0};
    //     dfs(root, Integer.MIN_VALUE, res);
    //     return res[0];
    // }

    // public void dfs(TreeNode root, int max, int[] res) {
    //     if(root == null) return;
    //     if(max <= root.val) res[0]++;
    //     max = Math.max(max, root.val);
    //     dfs(root.left, max, res);
    //     dfs(root.right, max, res);
    //     // max(max, root.val)
    // }
}
