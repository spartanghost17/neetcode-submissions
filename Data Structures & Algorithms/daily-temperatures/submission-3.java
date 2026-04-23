class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        //[30,38,30,36,35,40,28]
        //[30,29,28,40,27,26,42]
        //stack = [30,0]x,[38,1]h,[30,2]x,[]

        //[1,0,1,0,0,0,0]
        //[1,4,1,2,1,0,0]

        for(int i = 0; i < temperatures.length; i++) {//O(n)
            
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] head = stack.pop();
                res[head[1]] = i - head[1];
            }
            stack.push(new int[] {temperatures[i], i});
        }

        return res;
    }
}
