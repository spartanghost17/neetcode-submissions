class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Input: temperatures = [30,38,30,36,35,40,28]
        
        //s[[30,0]x , [38,1], [30,2]x, [36,3]x, [35,4]x, [40,5], [28,6]:h]
        //for i -> temps:

        //  while(!stack.isEmpty && temps[i] > stack.peek()[0]): ->
        //      int[] head = stack.peek()
        //      res[head[1]] = i - head[1]
        //      stack.pop()
        // stack.push([temps[i], i])
        
        //[1,4,1,2,1,0,0]
        //Output: [1,4,1,2,1,0,0]
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] head = stack.peek();
                res[head[1]] = i - head[1];
                stack.pop();
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}
