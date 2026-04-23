class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        //"4#neet4#code4#love3#you"
        //for i -> str
        //digitLen = i = 1
        //while -> str.isDigit(s.charAt(digitLen)) digitLen++
        //strLength = Integer.parseInt(str.substring(i, digitLen)) 
        // start = digitLen + 1 //2
        // end = start + strLength
        //subStr = str.substring(start, end)
        //list.add(subStr)
        // i = end - 1
        //i++
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            int digitLen = i;
            while(Character.isDigit(str.charAt(digitLen))) digitLen++;
            int strLength = Integer.parseInt(str.substring(i, digitLen));
            int start = digitLen + 1;
            int end = start + strLength;
            String subStr = str.substring(start, end);
            res.add(subStr);
            i = end - 1;
        }

        return res;

    }
}
