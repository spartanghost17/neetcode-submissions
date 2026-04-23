public class Solution {
    public List<List<int>> ThreeSum(int[] nums) {
        Array.Sort(nums); //nlog(n)
        //[-1,0,1,2,-1,-4]
        //[-4, -1, -1, 0, 1, 2]
        int target = 0;
        List<List<int>> res = new List<List<int>>();
        for(int i = 0; i < nums.Length; i++) {
            if(nums[i] > target) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1; int r = nums.Length - 1;
            while(l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if(sum < target) l++;
                else if(sum > target) r--;
                else {
                    res.Add(new List<int> {nums[i], nums[l], nums[r]});
                    l++; r--;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }

        return res;
    }
}
