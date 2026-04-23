class Solution {

    public String encode(List<String> strs) {
        
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        //-> "4#neet4#code4#love3#you"
        //          ^
        // for i ; i++ -> str:
        //   j = i -> 1
        //   while(Character.isDigit(str.charAt(j))) j++
        //   strLen = Integer.parseInt(str.substring(i, j))
        //   start = j + 1
        //   end = start + strLen
        //   str = str.substring(start, end)
        //   i = end - 1
        
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            int j = i;
            while(Character.isDigit(str.charAt(j))) j++;
            int strLen = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + strLen;
            res.add(str.substring(start, end));
            i = end - 1;
        }

        return res;
    }
}
