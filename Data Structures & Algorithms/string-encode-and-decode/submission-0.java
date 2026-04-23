class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String s : strs) {
            encodedStr.append(s.length()).append("#").append(s);
        }
        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i = 0;
        //3#cat3#bat
        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') j++;

            int wLen = Integer.valueOf(str.substring(i, j));
            
            i = j + 1 + wLen;
            decodedStrs.add(str.substring(j + 1, i));
        }

        return decodedStrs; 
    }
}
