class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        ops = []
        for s in tokens: 
            if s == "+":
                a = ops.pop()
                b = ops.pop()
                ops.append(a + b)
            elif s == "-":
                a = ops.pop()
                b = ops.pop()
                ops.append(b - a)
            elif s == "*":
                a = ops.pop()
                b = ops.pop()
                ops.append(a * b)
            elif s == "/":
                a = ops.pop()
                b = ops.pop()
                ops.append(int(b / a))
            else:
                ops.append(int(s))

        return ops[-1]
