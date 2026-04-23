class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        /**
        {
            [ : ]
            ] : [
        }
        **/
        //[[][[]]] -> Stack
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        //for i -> s.length(), i++
        //if(!stack.isEmpty())
        //else stack.add()
    
        //(]
        for(int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) == stack.peek()) {
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
