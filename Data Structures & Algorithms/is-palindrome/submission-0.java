class Solution {
    
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        //space ? remove spaces?
        //special ascii ? remove special ascii
        //s.replaceAll("[^a-zA-Z0-9]", "");
        
        while(left < right) {

            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != 
              Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }

        return true;
    }
    
    /*public boolean isPalindrome(String s) {

        //$
        String cleanS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanS.length() - 1;
        
        
        for(int i = 0; i < cleanS.length() / 2; i++) {
            if(cleanS.charAt(left) != cleanS.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }*/
}
