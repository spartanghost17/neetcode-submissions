class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      //cat -> tac = {a1c1t1: [cat, tac]} 
      //map groups
      //cat -> a1c1t1 
      //if key in groups -> add to array
      //groups
        Map<String, List<String>> groups = new HashMap<>();

        for(String s : strs) {
            String fkey = getFreqKey(s);

            // if(!groups.containsKey(fkey)) {
            //     groups.put(fkey, new ArrayList<>());
            // }

            // groups.get(fkey).add(s);

            groups.computeIfAbsent(fkey, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groups.values());

    }

    public String getFreqKey(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for(int i = 0; i < count.length; i++) {
            sb.append((char) (i + 'a')).append(count[i]);
        }

        return sb.toString();
    }
}
