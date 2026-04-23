class Solution {
    public boolean isAnagram(String s, String t) {
        //cat -> tac
        //O(n) -> O(m)
        //c1a1t1 = c1a1t1 
        if (s.length() != t.length()) return false;
        return getFreqKey(s).equals(getFreqKey(t));
    }

    public String getFreqKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sb.append((char) ('a' + i)).append(freq[i]);
            }
        }

        return sb.toString();
    }

}
