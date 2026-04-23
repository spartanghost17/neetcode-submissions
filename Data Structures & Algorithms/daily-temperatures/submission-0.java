class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //biggest up until i reach a greater value then current temp
        //O(n(logn + 1))
        //is there value on peek 
        //if yes 
        // check if current val is greater. 
        //else 
        // push if target is greater than current
        int[] res = new int[temperatures.length];    
        Stack<int[]> stack = new Stack<>(); 
        //Integer.MIN_VALUE -2.4b 
        //Integer.MAX_VALUE 2.4b
        for(int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while(!stack.isEmpty() && t > stack.peek()[0]) {
                int[] prev = stack.pop();
                res[prev[1]] = i - prev[1];
            }
            stack.push(new int[] {t, i});
        }

        return res;
    }
}
