class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        counts = {}
        maxf = 0
        longest = 0
        l  = 0
        for r in range(0, len(s)):
            counts[s[r]] = counts.get(s[r], 0) + 1
            maxf = max(maxf, counts[s[r]])
            while r - l + 1 - maxf > k: #invalid window
                counts[s[l]] = counts.get(s[l], 0) - 1
                l+=1

            longest = max(longest, r - l + 1)

        return longest