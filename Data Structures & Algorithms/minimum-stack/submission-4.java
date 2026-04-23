// class MinStack {
//     Stack<Integer> stack;
//     Stack<Integer> minStack;
//     public MinStack() {
//         stack = new Stack<>();
//         minStack = new Stack<>();
//     }
    
//     public void push(int val) {
//         //0 - 2 - 1
//         //0 - 1 - 1
//         int min = minStack.isEmpty() ? val : Math.min(val, minStack.peek()); 
//         minStack.push(min);
//         stack.push(val);
//     }
    
//     public void pop() {
//         stack.pop();
//         minStack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minStack.peek();
//     }
// }

class MinStack {
    Stack<Integer[]> stack;
    //Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        //this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        int min = !stack.isEmpty() ? Math.min(val, stack.peek()[1]) : val;
        this.stack.push(new Integer[] {val, min});
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}
