# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        best = [0]
        self.dfs(root, best)
        return best[0]
    
    def dfs(self, root: Optional[TreeNode], best: List[int]) -> int:
        if not root:
            return 0
        hLeft = self.dfs(root.left, best)
        hRight = self.dfs(root.right, best)
        best[0] = max(best[0], hLeft + hRight)

        return max(hLeft, hRight) + 1