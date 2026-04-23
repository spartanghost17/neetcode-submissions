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
        path1 = [] # O(log(n)) or worst case O(n)
        path2 = []

        self.ancestor(root, p, path1) # time: O(log(n))
        print(path1)
        self.ancestor(root, q, path2) # time: O(log(n))
        print("p1")
        for i in path1:
            print(i.val)
        print("p2")
        for i in path2:
            print(i.val)
        
        if len(path1) != len(path2):
            longest = path2 if len(path2) > len(path1) else path1
            for i in range(abs(len(path2) - len(path1))):
                node = longest.pop()
                print(f"poping: {node.val}")

        
        while path1[-1].val != path2[-1].val:
            print(f"val {path1[-1].val}")
            path1.pop()
            path2.pop()
        
        return path1[-1]


    def ancestor(self, root: TreeNode, target: TreeNode, path: list):
        if not root:
            return

        path.append(root)
        if root.val == target.val:
            return
            
        if target.val < root.val:
            self.ancestor(root.left, target, path)
        else:
            self.ancestor(root.right, target, path)
            


