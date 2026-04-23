class TimeMap:

    def __init__(self):
        self.timeMap = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.timeMap:
            self.timeMap[key] = []
        self.timeMap[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        #if key in dict
        # 
        #else ""
        #{key: [[], [], [], []]}

        # [[happy, 1], [sad, 3]]
        # mid <= target: -> 
        # ans = [mid][0]
        # l = mid + 1
        # else:
        #   r = mid - 1
        ans = ""
        if key not in self.timeMap:
            return ans
        
        arr = self.timeMap[key]
        
        l, r = 0, len(arr) - 1
        while l <= r:
            mid = l + (r - l) // 2

            if arr[mid][1] <= timestamp:
                ans = arr[mid][0]
                l = mid + 1
            else:
                r = mid - 1
        return ans
