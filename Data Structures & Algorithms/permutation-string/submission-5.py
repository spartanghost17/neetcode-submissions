class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        # 26 english letters lowercase
        # s2 < s1 return false
        # len(s1) -> k 
        # s1 -> freqstr = a1b1c1
        # l = 0
        # r = k - 1
        # while r < len(s2):
        # substr(l, r) -> freqstr = freqarr
        # if freq1 == freq2 : return true
        # else:
        #   l++
        #   r++

        k = len(s1)
        freq_arr1 = self.getFreq(s1)
        l = 0
        for r in range(k - 1, len(s2)):
            window = s2[l:r + 1]
            freq_arr2 = self.getFreq(window) # get substring frequency
            if freq_arr1 == freq_arr2:
                return True
            else:
                l += 1 # remove from window

        return False

    def getFreq(self, s: str) -> List[int]:
        freq_arr = [0 for _ in range(26)] # [0] * 26
        for c in s:
            freq_arr[ord('a') - ord(c)] += 1
        
        return freq_arr