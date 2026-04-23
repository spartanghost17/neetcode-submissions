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
    // public Node cloneGraph(Node node) {
    //     Map<Node, Node> visited = new HashMap<>();
    //     Node res = dfs(node, visited);
    //     return res;
    // }

    // public Node dfs(Node node, Map<Node, Node> visited) {
    //     if(node == null) return null;
    //     if(visited.containsKey(node)) return visited.get(node);
        
    //     //add to visited set
    //     Node clone = new Node(node.val);
    //     visited.put(node, clone);

    //     for(Node v : node.neighbors) {
    //         Node n = dfs(v, visited);
    //         clone.neighbors.add(n);
    //     }
    //     return clone;
    // }


    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            for(Node v : curr.neighbors) {
                if(!visited.containsKey(v)) {
                    queue.offer(v);
                    visited.put(v, new Node(v.val));
                }

                // add cloned neighbors node to cloned current node
                visited.get(curr).neighbors.add(visited.get(v));
            }

        }

        return visited.get(node);
    }
}