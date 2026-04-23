class Solution {
    public int lengthOfLongestSubstring(String s) {
        //maxLen = 0
        //l = 0
        //r = 1
        //set(z,x,y)
        //if(set.contains(s.charAt(r)))
        // maxLen = Math.max(maxLen, set.size())
        // l = r
        // set = new Set<>();
        //set.add(s.charAt(r))
        //r++
        //s = "zxyzxyz"
        //s = "zxyxabc"
        int maxLen = 0;
        int l = 0;
        //int r = 0;
        Set<Character> set = new HashSet<>();
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
