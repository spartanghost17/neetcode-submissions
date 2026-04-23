# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return self.dfs(p, q)
    def dfs(self, p, q):
        if p is None and q is None:
            return True
        if (p and q is None) or (p is None and q):
            return False
        #if q is None:
        #    return True
        
        if p.val != q.val:
            return False

        return self.dfs(p.left, q.left) and self.dfs(p.right, q.right)

