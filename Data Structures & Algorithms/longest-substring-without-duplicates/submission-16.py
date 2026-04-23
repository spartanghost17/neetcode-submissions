class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # longest substr != repeating chars
        # for r in range(len(s)):
        #
        #   while window != valid:
        #       remove arr[l] from window
        #       l++
        #   add arr[r] to window
        l = 0
        unique = set()
        maxLen = 0
        for r in range(len(s)):
            while s[r] in unique:
                unique.remove(s[l])
                l += 1
            unique.add(s[r])
            maxLen = max(maxLen, r - l + 1)
        
        return maxLen