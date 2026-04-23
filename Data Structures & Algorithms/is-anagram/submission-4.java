class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = getFrequency(s);
        String t1 =  getFrequency(t);

        return s1.equals(t1);
    }

    public String getFrequency(String s) {
        StringBuilder sb = new StringBuilder();
        //26
        //{"a": 4}
        int[] freq = new int[26];
        //int a = 'a'//126
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // for(int i = 0; i < freq.length; i++) {
        //     if(freq[i] > 0)
        //        s.append(s.charAt(i)).append(freq[i]);
        // }
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) 
                sb.append((char)('a' + i)).append(freq[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
