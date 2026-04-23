class Solution {
    public int evalRPN(String[] tokens) {
        //stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {

            if(tokens[i].equals("+")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push((val1 + val2));
            } 
            else if(tokens[i].equals("-")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push((val1 - val2));
            }
            else if(tokens[i].equals("*")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push((val1 * val2));
            } 
            else if(tokens[i].equals("/")) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                stack.push((val1 / val2));
            } 
            else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
