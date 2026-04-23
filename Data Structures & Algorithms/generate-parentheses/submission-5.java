class Solution {
    int n;
    private void backtrack(int openN, int closedN, StringBuilder sb, List<String> res) {
        //openN = n && closedN = openN
        if(openN == this.n && closedN == openN) {
            res.add(sb.toString());
        }

        //if(openN < n)
        if(openN < this.n) {
            sb.append("(");
            backtrack(openN + 1, closedN, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        //if(closedN < openN)
        if(closedN < openN) {
            sb.append(")");
            backtrack(openN, closedN + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> generateParenthesis(int n) {
        this.n = n;
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(0, 0, sb, res);
        return res;
    }
}
