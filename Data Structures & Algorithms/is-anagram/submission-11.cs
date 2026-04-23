public class Solution {
    public bool IsAnagram(string s, string t) {
        //return getFreq(s).SequenceEqual(getFreq(t));
        return getFreq(s) == getFreq(t);
    }

    public string getFreq(string s) {
        int[] freq = new int[26];
        foreach(char c in s.ToCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < freq.Length; i++) {
            if(freq[i] > 0) {
                sb.Append('a' + i).Append(freq[i]);
            }
            //a1b2c3
        }
        Console.WriteLine(sb.ToString());
        //Console.WriteLine(string.Join(", ", freq));
        return sb.ToString();
    }
}
