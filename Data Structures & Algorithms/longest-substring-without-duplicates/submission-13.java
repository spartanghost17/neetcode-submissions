class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Input: s = "zxyzxyz"
        //set populated as the right pointer moves ->
        //for i -> s.toCharArray:
            //if set.contains(s.charAt(r))
            //  set.remove(s.charAt(r))
            //  l++
            //set.add(s.charAt(r))
            //max =  max(max, r - l + 1)

        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }   
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
