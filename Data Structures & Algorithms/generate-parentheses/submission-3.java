class Solution {
    private Map<String, List<String>> memo = new HashMap<>();
    private int n;

    private List<String> generateWithMemo(int openN, int closedN) {
        String key = openN + "," + closedN;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        List<String> result = new ArrayList<>();
        
        if (openN == this.n && closedN == this.n) {
            result.add("");
            return result;
        }
        
        // Try adding open parenthesis if we haven't used all n
        if (openN < this.n) {
            List<String> openResults = generateWithMemo(openN + 1, closedN);
            for (String s : openResults) {
                result.add("(" + s);
            }
        }
        
        // Try adding closing parenthesis if it's valid (won't create unbalanced string)
        if (closedN < openN) {
            List<String> closedResults = generateWithMemo(openN, closedN + 1);
            for (String s : closedResults) {
                result.add(")" + s);
            }
        }
        
        // Cache the result before returning
        memo.put(key, result);
        return result;
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        List<String> result = generateWithMemo(0, 0);
        return result;
    }
}


        //{((}
        // if(memo.containsKey(sb.toString())) return 
        // if(closedN == openN && openN == n) {
        //     res.add(sb.toString());
        //     return;
        // }

        // if(openN < n) {
        //     sb.append('(');
        //     backTrack(openN + 1, closedN, sb, res, memo);
        //     //memo
        //     sb.deleteCharAt(sb.length() - 1);
            
        // }
        // if(closedN < openN) {
        //     sb.append(')');
        //     backTrack(openN, closedN + 1, sb, res, memo);
        //     sb.deleteCharAt(sb.length() - 1);
        // }