class Solution {
    public int evalRPN(String[] tokens) {
        //["1","2","+","3","*","4","-"]
        // 2 -> 1
        // 3 -> 3
        // 4 -> 9
        // if op == "+":
        // val2 = stack.pop()
        // val1 = stack.pop()
        // val1 + val2 = res
        // stack.push(res) 
        //((1 + 2) * 3) - 4 = 5

        Stack<Integer> stack = new Stack<>();

        for(String s : tokens) {
            if(s.equals("+")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = val1 + val2;
                stack.push(res);

            } else if(s.equals("-")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = val1 - val2;
                stack.push(res);
            } else if(s.equals("*")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = val1 * val2;
                stack.push(res);
            } else if (s.equals("/")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int res = val1 / val2;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
