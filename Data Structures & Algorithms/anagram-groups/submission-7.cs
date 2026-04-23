public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> groups = new Dictionary<string, List<string>>();
        foreach(string s in strs) {
            string key = getKey(s);
            if(!groups.ContainsKey(key)) {
                groups.Add(key, new List<string>());
            }
            groups[key].Add(s);
        }

        return new List<List<string>>(groups.Values);
    }

    public string getKey(string s) {
        int[] freq = new int[26];
        foreach(char c in s.ToCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq.Length; i++) {
            if(freq[i] > 0) sb.Append('a' + i).Append(freq[i]);
        }

        return sb.ToString();
    }
}
