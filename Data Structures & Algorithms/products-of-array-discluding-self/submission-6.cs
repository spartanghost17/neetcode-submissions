public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int[] pref = new int[nums.Length];
        int[] suff = new int[nums.Length];
        int[] res = new int[nums.Length];
        //[1,2,4,6]
        //[1,1,2, ]
        pref[0] = 1;
        suff[nums.Length - 1] = 1;
        for(int i = 1; i < nums.Length; i++) {
            pref[i] = pref[i - 1] * nums[i - 1];
        }
        for(int i = nums.Length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.Length; i++) {
            res[i] = pref[i] * suff[i]; 
        }

        return res;
    }
}
