class Solution {
    public int[] productExceptSelf(int[] nums) {
        //nums[]
        //nums=[1,2,4,6] -> O(n^n-1)
        //     [1,x,24]
        //preMult = 1
        //postMult = 1
        //prefix = []
        //postfix = []
        // for -> nums, i++:
        // prefix[i] = nums[i] * preMult
        // preMult = prefix[i] = 8
        //prefix =  [1, 1, 2, 8]

        //pref = [1,  1,  2, 8] ->pass 1
        //post = [48, 24, 6, 1]
        
        // for -> nums, i--:
        // postfix[i] = nums[i] * postMult
        // postMult = postfix[i]
        // 
        //postfix = [48, 48, 24, 6]
        //output=[48,24,12,8]

        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] post = new int[n];

        pref[0] = 1;
        post[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1]; 
        }

        for(int i = n - 2; i >= 0; i--) {
            post[i] = nums[i + 1] * post[i + 1];
        }

        for(int i = 0; i < n; i++) {
            res[i] = pref[i] * post[i];
        }

        return res;
    }
}  
