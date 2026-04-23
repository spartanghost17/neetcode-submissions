public class Solution {
    public bool IsAnagram(string s, string t) {
        return getFreq(s).SequenceEqual(getFreq(t));
    }

    public int[] getFreq(string s) {
        int[] freq = new int[26];
        foreach(char c in s.ToCharArray()) {
            freq[c - 'a']++;
        }
        Console.WriteLine(string.Join(", ", freq));
        return freq;
    }
}
