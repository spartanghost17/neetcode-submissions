class Solution {
    public boolean isValid(String s) {
        //map = {'}': '{'}
        //stack = []
        //for i, v in enumerate(s):
        //if not (len(stack) == 0) and (v in map) and s[-1] == map.get(v):
        //  stack.pop()
        //else:
        //  stack.append(v)
        //return len(stack) == 0

        Map<Character, Character> brackets = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && brackets.containsKey(c) && stack.peek() == brackets.get(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
