class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //tem[i] = temp on ith day
        //temp[1] = temp on day 1
        //res[i]n = n days after ith where some warmer temp appeared 

        // if no day in future is warmer than temp[i] set res[i] = 0


        //Input: temperatures = [30,38,30,36,35,40,28]

        //Output: [1,4,1,2,1,0,0]
        //30 -> 38
        //int[] res = new int[temperatures.length]
        //for i -> temperatures:
            //int counter = 0;
            //for j = i -> sub(temperatures):
            //res[i] = res[j]
            //break


        // Input: temperatures = [22,21,20]
        // 22 -> 21 -> 20
        // Output: [0,0,0]
        // stack
        // target = 0 
        // counter = 0
        // stack.push(temperatures[0])
        // while(!stack.isEmpty())
        //   counter+=1
        //   if stack.peek() < temperatures[target + counter]:
        //     res[target] = temperatures[counter]
        //     counter = 0;
        //     target++;
        //     stack.push(temperatures[target])
        //  else:
        //     stack.push(temperatures[target + counter])
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return res;
    }
}
