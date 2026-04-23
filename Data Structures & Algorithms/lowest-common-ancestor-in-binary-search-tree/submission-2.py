# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # [5, 8] -> p = 5 , q = 8
        # if p = 4 and q = 10
        # 5 -> 3 -> 1 -> 2 -> null
        # 5 -> 3 -> 4 -> null
        # sol 1: 5 -> 3 -> 4 | when node.val == p.val or node.val == q.val -> add to permanent solution  
        # sol 2: 5 -> 8 -> 9 -> 10 -> |

        # explore path dfs -> if node.val == p.val || node.val == q.val: -> return node
        # need some way of remembering the path i took
        # maybe need to know at what level i found the node -> than use level of p - level of q 
        # if diff(level p - level q) == 0: -> take ancestor at level 0
        # if diff(level p - level q) == 1: -> take ancestor at level 1
        stack = [] # O(n) if balanced O(log(n))
        solutions = defaultdict(list) # O(n) if balanced O(log(n)) 

        self.ancestor(root, p, q, stack, solutions)    
        
        sol1 = solutions[1]
        sol2 = solutions[2]

        length = min(len(sol1) - 1, len(sol2) - 1)

        for i in range(length, -1, -1):
            if sol1[i].val == sol2[i].val:
                return sol1[i]

    def ancestor(self, root: TreeNode, p: TreeNode, q: TreeNode, stack: list, solutions: dict):
        if not root:
            return
        
        if len(solutions) == 2:
            return
            
        stack.append(root)
        if root.val == p.val:
            solKey = len(solutions) + 1
            for node in stack:
                solutions[solKey].append(node)
            
        if root.val == q.val:
            solKey = len(solutions) + 1
            for node in stack:
                solutions[solKey].append(node)

        self.ancestor(root.left, p, q, stack, solutions)
        self.ancestor(root.right, p, q, stack, solutions)

        if stack:
            stack.pop()


