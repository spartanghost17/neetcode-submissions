/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Node res = dfs(node, visited);
        return res;
    }

    public Node dfs(Node node, Map<Node, Node> visited) {
        if(visited.containsKey(node)) return visited.get(node);
        
        //add to visited set
        Node clone = new Node(node.val);
        visited.put(node, clone);

        for(Node v : node.neighbors) {
            Node n = dfs(v, visited);
            clone.neighbors.add(n);
            // if(!visited.containsKey(v)) {
            //     //visited.offer(v);
            //     Node n = dfs(v, visited);
            //     clone.neighbors.add(n);
            // } else {
            //     clone.neighbors.add(visited.get(v));
            // }
        }
        return clone;
    }
}