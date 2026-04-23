class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String s : strs) {
            String anagram = getAnagram(s);

            if(!anagrams.containsKey(anagram)) {
                anagrams.put(anagram, new ArrayList<>());
            }

            anagrams.get(anagram).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }

    public String getAnagram(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > 0) {
                sb.append((char) 'a' + i).append(freq[i]);
            }
        }

        return sb.toString();
    }
}
