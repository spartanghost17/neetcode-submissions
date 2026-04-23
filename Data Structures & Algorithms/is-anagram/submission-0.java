//import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        String freq1 = getFreq(s);
        String freq2 = getFreq(t);

        if(freq1.compareTo(freq2) != 0) {
            return false;
        }

        return true;
    }

    public String getFreq(String s) {

        int freq[] = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                sb.append(String.valueOf((char)('a' + i))).append(String.valueOf(freq[i]));
            }
        } 
        System.out.println(sb.toString());
        return sb.toString();
    }
}
