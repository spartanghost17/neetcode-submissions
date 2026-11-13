class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for(String s : strs) {//O(n)

            String key = getFreq(s);//O(m)
            if(!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(s);
        }
        
        return new ArrayList<>(groups.values());
    }

    public String getFreq(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sb.append((char)('a' + i)).append(freq[i]);
            }
        }

        return sb.toString();
    }
}
