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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 0;
        dfs(root, diameter); 
        return diameter[0];
    }

    public int dfs(TreeNode root, int[] diameter) {
        if(root == null) return 0;
        
        int hLeft = dfs(root.left, diameter);
        int hRight = dfs(root.right, diameter);
        int currDiam = hLeft + hRight;
        diameter[0] = Math.max(diameter[0], currDiam);

        return Math.max(hLeft, hRight) + 1;
    }
}
