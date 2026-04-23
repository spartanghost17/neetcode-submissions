# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        

    # all nodes unique
    # if root == null and subroot == null: return true

    # if (root == null and subroot != null) or (root != null and subTree == null):
    #   return False

    # if root.val == subRoot.val:
    #   recurse left & right
    #   return dfs(root.left, subRoot.left) and dfs(root.right, subroot.right)
    # else:
    #   return False
    # return dfs(root.left, subRoot) or dfs(root.right, subRoot)
        if not root:
            return False
        
        if self.isSame(root, subRoot):
            return True
    
        return (self.isSubtree(root.left, subRoot) or
            self.isSubtree(root.right, subRoot))
    
    def isSame(self, p, q):
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        
        return self.isSame(p.left, q.left) and self.isSame(p.right, q.right)

        
