class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxSeq = 0;
        Set<Character> set = new HashSet<>();

        for(int r = 0; r < s.length(); r++) {

            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxSeq = Math.max(maxSeq, r - l + 1);
        }
        //O(m)
        //O(n)
        return maxSeq;
    }
}
