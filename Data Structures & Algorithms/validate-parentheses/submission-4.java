class Solution {
    public boolean isValid(String s) {

        //{]:[, }:{, ):(}
        //(, [, {
        //([{)
        Map<Character, Character> lookup = new HashMap<>();
        lookup.put(')', '(');
        lookup.put(']', '[');
        lookup.put('}', '{');
        
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if(lookup.containsKey(s.charAt(i))) {
                if(!stack.isEmpty() && lookup.get(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }


        return stack.isEmpty();
    }
}
