# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # if reach leaf node -> means we reached the end and couldn't validate structure
        if not root:
            return False 
        # check is same for every node
        if self.isSame(root, subRoot):
            return True
        # return left if left == true else right == true | subRoot does not change since it's source of truth
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def isSame(self, root: TreeNode, subRoot: TreeNode) -> bool:
        if not root and not subRoot:
            return True
        if not root or not subRoot:
            return False
        if root.val != subRoot.val:
            return False
        
        return self.isSame(root.left, subRoot.left) and self.isSame(root.right, subRoot.right)
        