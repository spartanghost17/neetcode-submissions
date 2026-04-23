class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        // h:-> x -> 2 -> 1
        //      x    1    1
    }
    
    public void push(int val) {
        int prev = minStack.isEmpty() ? val : minStack.peek();
        int min = Math.min(prev, val);
        this.stack.push(val);
        this.minStack.push(min);
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
