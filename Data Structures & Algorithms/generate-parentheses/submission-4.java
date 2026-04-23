class Solution {
    private int n;
    public void backTrack(int openN, int closedN, StringBuilder sb, List<String> res) {
        //n=1 -> closedN == openN && openN == n
        //go open -> openN < n: (sb.deleteCharAt(sb.length() - 1))
        //go closed -> closedN < openN: (sb.deleteCharAt(sb.length() - 1))
        if(closedN == openN && openN == this.n) {
            res.add(sb.toString());
            return;
        }

        if(openN < this.n) {
            sb.append("(");
            backTrack(openN + 1, closedN, sb, res);
            sb.deleteCharAt(sb.length() - 1);          
        }

        if(closedN < openN) {
            sb.append(")");
            backTrack(openN, closedN + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTrack(0, 0, sb, res);

        return res;
    }
}
