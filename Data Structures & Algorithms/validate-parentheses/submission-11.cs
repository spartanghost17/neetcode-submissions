public class Solution {
    public bool IsValid(string s) {
        var stack = new Stack<char>();
        var map = new Dictionary<char, char>{
            {')', '('},
            {'}', '{'},
            {']', '['}
        };

        foreach(char c in s) {
            if(stack.Count > 0 && map.ContainsKey(c) && map[c] == stack.Peek()) {
                stack.Pop();
            } else {
                stack.Push(c);
            }
        }

        return stack.Count == 0;
    }
}
