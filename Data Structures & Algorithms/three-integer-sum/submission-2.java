class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = nums.length - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0) {
                    l++;
                } else if(sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }

        return res;
    }
    /*public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //O(nlogn) + O(n*m)
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            if(!set.contains(nums[i])) {
                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum < 0) {
                        left++;
                    } else if(sum > 0) {
                        right--;
                    } else {
                        List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                        res.add(triplet);
                        set.add(nums[i]);
                        left++;
                    }
                }
            }

        }
        return res;
    }*/
}
