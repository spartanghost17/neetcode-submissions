# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
    
        hLeft = self.dfs(root.left)
        hRight = self.dfs(root.right)
    
        if abs(hLeft - hRight) > 1:
            return False

        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def dfs(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        hLeft = self.dfs(root.left)
        hRight = self.dfs(root.right)
        
        return max(hLeft, hRight) + 1