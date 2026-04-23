class Solution {
    public boolean isPalindrome(String s) {
        //w????aw
        //     ^^
        //for -> s.toCharArray()
        // while(l < r)
        // to compare both pointers must point at char
        // l = 0
        // r = s.length() - 1
        // if(! isLetter(s.charAt(l))) l++
        // if(! isLetter(s.charAt(r))) r--
        // if(!toLowerCase(s.charAt(l))
        // .equals(toLowerCase(s.charAt(l))))
        //  return false;
        // l++; r--;
        //return true
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))) r--;
            System.out.println("str: "+s+" countL: "+l+" right "+r);
            if(Character.toLowerCase(s.charAt(l)) != (Character.toLowerCase(s.charAt(r))))
                return false;

            l++; r--;
        }

        return true;
        // if isLetter(c)
        // Character.toLowerCase(c)
    }
}
