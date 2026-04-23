class Solution {
    public int lengthOfLongestSubstring(String s) {
        //axcbdbh]
        int l = 0, maxS = 0;
        Set<Character> set = new HashSet<>();
        //set for uniqueness
        //while set.contains(s.charAt(r)):
        //set.remove(s.charAt(r))
        //l++
        //maxS = max(maxS, r - l + 1)

        for(int r = 0; r < s.length(); r++) {//O(n)

            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            maxS = Math.max(maxS, (r - l + 1));
            set.add(s.charAt(r));
        }

        return maxS;
    }
}
