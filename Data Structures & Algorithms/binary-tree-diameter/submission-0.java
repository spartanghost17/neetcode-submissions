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
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0]; 
    }

    public int dfs(TreeNode root, int[] maxDiameter) {
        if(root == null) return 0;

        int left_height = dfs(root.left, maxDiameter);
        int right_height = dfs(root.right, maxDiameter);
        int diameter = left_height + right_height;
        maxDiameter[0] = Math.max(maxDiameter[0], diameter);
        return Math.max(left_height, right_height) + 1;
    }
}
