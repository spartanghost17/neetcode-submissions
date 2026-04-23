# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        left_h = self.dfs(root.left) 
        right_h = self.dfs(root.right)

        if abs(left_h - right_h) > 1:
            return False

        return self.isBalanced(root.left) and self.isBalanced(root.right)

    def dfs(self, root) -> int:
        if root is None:
            return 0
        
        left_h = self.dfs(root.left)
        right_h = self.dfs(root.right)

        return max(left_h, right_h) + 1