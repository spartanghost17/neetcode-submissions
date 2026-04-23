class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        //should be able to track min val in stack
        //-> stack find (available like peek)
        //x -> 2 -> 1
        //x -> 1 -> 1
        //getMin O(1) ->
        // currMin = min(val_pushed, prev_min) 
        //  = 1 -> 2 
        //Stack<int[val, currMin]>
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        int prevMin = this.stack.isEmpty()? 
                        val : this.minStack.peek();
        int min = Math.min(val, prevMin);
        
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
