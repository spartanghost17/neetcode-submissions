# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [-2**31]
        self.dfs(root, res)
        return res[0]
    
    def dfs(self, root: TreeNode, res: list[int]) -> int:
        if not root:
            return 0

        left = max(0, self.dfs(root.left, res))
        right = max(0, self.dfs(root.right, res))

        maxVal = left + right + root.val 
        res[0] = max(res[0], maxVal)
        best = max(left, right)
        best = root.val + best if root.val + best > root.val else root.val

        return best