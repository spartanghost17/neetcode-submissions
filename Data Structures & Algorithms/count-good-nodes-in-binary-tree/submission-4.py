# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        return self.dfs(root, root.val)
    
    def dfs(self, root: TreeNode, maxValue: int) -> int:
        if not root:
            return 0
        res = 1 if root.val >= maxValue else 0 
        maxValue = max(root.val, maxValue)
        res += self.dfs(root.left, maxValue)
        res += self.dfs(root.right, maxValue)
        return res
    # def goodNodes(self, root: TreeNode) -> int:
    #     target: TreeNode = root
    #     count: list = [0]
    #     self.goodCount(root, target, count)
    #     return count[0]
    
    # def goodCount(self, root: TreeNode, target: TreeNode, count: list):
    #     if not root or not target:
    #         return
    #     if self.isGood(root, target):
    #         count[0] += 1
    #     self.goodCount(root, target.left, count)
    #     self.goodCount(root, target.right, count)

    # def isGood(self, root: TreeNode, target: TreeNode) -> bool:
    #     # if this is target node root == target: return 1
    #     # if root.val > target.val: return 0
    #     if not root or root.val > target.val:
    #         return False
    #     if root == target:
    #         return True
        
    #     return self.isGood(root.left, target) or self.isGood(root.right, target)