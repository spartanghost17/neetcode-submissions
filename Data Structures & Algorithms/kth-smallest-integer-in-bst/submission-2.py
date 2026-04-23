# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        count = [k, 0]
        self.dfs(root, count)
        return count[1]

    def dfs(self, root, count) -> None:
        if not root or count[0] == 0:
            return
        
        self.dfs(root.left, count)
        
        count[0] -= 1
        if count[0] == 0:
            count[1] = root.val
            return
        self.dfs(root.right, count)
        
