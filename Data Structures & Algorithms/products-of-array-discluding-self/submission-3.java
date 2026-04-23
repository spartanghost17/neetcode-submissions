class Solution {
    public int[] productExceptSelf(int[] nums) {
        //nums = [1, 2,  4, 6]
        //prefix[1,  1,  2, 8]
        //postfix[48, 24, 6, 1]
        //out: [48,24,12,8]

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] res = new int[nums.length];

        int pre = 1;
        prefix[0] = 1;
        postfix[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++){
            pre *= nums[i - 1];
            prefix[i] = pre;  
        }

        int post = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            post *= nums[i + 1];
            postfix[i] = post;
        }

        for(int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * postfix[i];
        }

        return res;
    }
}  
