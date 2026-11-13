class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq1 = self.getFreq(s)
        freq2 = self.getFreq(t)

        return freq1 == freq2

    def getFreq(self, s: str) -> list[int]:
        freq = [0] * 26
        
        for c in s: # a -> 11 - 10 = 1 idx = 1 
            freq[ord(c) - ord('a')] += 1
        
        return freq


    # a2c2e1r2