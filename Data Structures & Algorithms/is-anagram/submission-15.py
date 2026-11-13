class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freq1 = self.getFreq(s)
        freq2 = self.getFreq(t)

        return freq1 == freq2

    def getFreq(self, s: str) -> str:
        freq = [0] * 26
        
        for c in s: # a -> 11 - 10 = 1 idx = 1 
            freq[ord(c) - ord('a')] += 1
        
        sb = []

        for i, v in enumerate(freq):
            if(v != 0):
                sb.append(chr(ord('a') + i))
                sb.append(str(v))

        return "".join(sb)


    # a2c2e1r2