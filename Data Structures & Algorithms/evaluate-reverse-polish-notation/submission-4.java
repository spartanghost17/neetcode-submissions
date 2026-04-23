class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ops = new Stack<>();
        int res = 0;
        for(String s : tokens) {
            if(s.equals("+")) {
                int a = ops.pop();
                int b = ops.pop();
                ops.push(a + b);
            } else if(s.equals("-")) {
                int a = ops.pop();
                int b = ops.pop();
                ops.push(b - a);
            } else if(s.equals("*")) {
                int a = ops.pop();
                int b = ops.pop();
                ops.push(a * b);
            } else if (s.equals("/")) {
                int a = ops.pop();
                int b = ops.pop();
                ops.push(b / a);
            } else {
                ops.push(Integer.parseInt(s));
            }
        }

        return ops.peek();
    }
}
