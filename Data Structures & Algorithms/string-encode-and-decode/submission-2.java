class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }    

    public List<String> decode(String str) {
        // list list;
        List<String> res = new ArrayList<>(); //O(n)
        //"10#neettdshee4#code4#love4#you"
        //    ^
        // for loop -> str.length(), i++
        for(int i = 0; i < str.length(); i++) { //O(n)
        //  j = i = 14
            int j = i;
        //  while isDigit(str[j]) j++
            while(Character.isDigit(str.charAt(j))) j++; 
        //  len = Integer.parseInt(str.substring(i, j))
            int len = Integer.parseInt(str.substring(i, j));
        //  start = j + 1;
            int start = j + 1;
        //  end = len + j + 1;
            int end = len + j + 1;
        //  substring = str.substring(start, end);
            String substring = str.substring(start, end);
        //  list.add(substring)
            res.add(substring);
        //  i = (len + j)
            i = len + j;
        }
        // return list
        return res;
        // i = 2;
        // len = 10
    }
}
