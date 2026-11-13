class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = {}
        for s in strs:
            key = self.getFreq(s)
            if key not in groups:
                groups[key] = []
            groups[key].append(s)
        
        return list(groups.values())
        

    def getFreq(self, s: str) -> str:
        seen = [0] * 26
        
        for c in s:
            seen[ord(c) - ord('a')] += 1
        
        sb = []
        
        for i, v in enumerate(seen):
            sb.append(chr(ord('a') + i))
            sb.append(str(v))
        
        return "".join(sb)