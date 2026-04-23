class Solution {
    public int longestConsecutive(int[] nums) {
        //min-heap -> 
        //[2, 20, 4, 10, 3, 5]
        
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        //| [2, 3, 4, 5]  [10] [20]
        //|----------------------------->
        //| X

        // !set.contains(n-1)
        // length = 1;
        // while(set.contains(n+1)) length++;
        // prevLength = Math.max(length, prevLength);
        int length = 0;
        for(int n : set) {
            if(!set.contains(n-1)){
               int currLength = 1;
               while(set.contains(n + currLength)) currLength++;
               length = Math.max(length, currLength);
            }
        }

        return length;
    }
}
