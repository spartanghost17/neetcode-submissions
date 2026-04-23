public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        int l = 0; int r = numbers.Length - 1;

        for(int i = 0; i < numbers.Length; i++) {
            int sum = numbers[l] + numbers[r];

            if(sum < target) l++;
            else if(sum > target) r--;
            else return new int[] {l+1, r+1};
        }

        return new int[] {-1, -1};
    }
}
