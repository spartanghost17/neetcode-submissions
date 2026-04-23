//import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        

        String anagram1 = freqStr(s);
        String anagram2 = freqStr(t);

        if(anagram1.compareTo(anagram2) == 0) return true; 
        
        return false;
    }


    public String freqStr(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < freq.length; i++) {
            sb.append((char)'a' + i).append(freq[i]);
        }

        return sb.toString();
    }


}
