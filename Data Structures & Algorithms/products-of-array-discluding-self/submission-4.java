class Solution {
    public int[] productExceptSelf(int[] nums) {

        //nums = [1, 2, 4, 6]
        //preVal = nums[0] -> 4
        //for i = 1 -> nums:
        //  pref[i] = pref[i - 1] * preVal 
        //  preVal = nums[i]
        //pref = [1, 1, 2, 8]

        //postVal = nums[nums.length - 1] -> 2
        //for i = nums.length - 2, i-- -> nums:
        //  post[i] = post[i + 1] * postVal
        //  postVal = nums[i]
        //post = [48, 24, 6, 1]
        int[] pref = new int[nums.length];
        int[] post = new int[nums.length];
        int[] res  = new int[nums.length];

        int preVal = nums[0];
        pref[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * preVal;
            preVal = nums[i];
        }

        int postVal = nums[nums.length - 1];
        post[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            post[i] = post[i + 1] * postVal;
            postVal = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            res[i] = pref[i] * post[i];
        }

        return res;
    }
}  
