# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        
        queue = deque([root])
        res = []
        while len(queue) > 0:
            count = len(queue)
            last: TreeNode = None
            for i in range(count):
                last = queue.popleft()
                if last.left:
                    queue.append(last.left)
                if last.right:
                    queue.append(last.right)
            res.append(last.val)
        
        return res