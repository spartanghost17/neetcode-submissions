class Solution {
    public boolean isValid(String s) {
        //{ }
        boolean isValid = true;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketLookup = new HashMap<>(3);

        bracketLookup.put(')', '(');
        bracketLookup.put('}', '{');
        bracketLookup.put(']', '[');
        
        for(char c : s.toCharArray()) {
            if(bracketLookup.containsKey(c)) {
                if(!stack.isEmpty() && bracketLookup.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
