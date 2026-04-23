class Solution:
    def isValid(self, s: str) -> bool:
        brackets = {')': '(', '}': '{', ']': '['}
        stack = []
        for i, c in enumerate(s):
            if not (len(stack) == 0) and c in brackets and stack[-1] == brackets.get(c):
                stack.pop()
            else:
                stack.append(c)
        
        return len(stack) == 0
