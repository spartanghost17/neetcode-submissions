class Solution {
    public boolean isAnagram(String s, String t) {
        //cat -> tac
        //O(n) -> O(m)
        //c1a1t1 = c1a1t1 
        String s1 = getKey1(s);
        String s2 = getKey1(t);
        return s1.equals(s2);
    }

    public String getKey1(String s) {
        int[] count = new int[26];
        for(int c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count.length; i++) {
            sb.append('a' + i).append(count[i]);
        }

        return sb.toString();

    }

}
