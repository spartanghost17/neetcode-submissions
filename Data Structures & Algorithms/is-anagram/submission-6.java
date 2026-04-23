class Solution {
    public boolean isAnagram(String s, String t) {
        //Input: s = "jar", t = "jam"
        //j1a1r1 - j1a1r1
        //26 -> 'a' -> 126 -> [b - 'a']++
        return getFreqString(s).equals(getFreqString(t));
    }

    public String getFreqString(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        //abc
        //[1,1,1,...0]

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sb.append((char)('a' + i)).append(freq[i]);
            }
        }

        return sb.toString();
    }
}
