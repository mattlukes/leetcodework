/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with
val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.

Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of
neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to
the cloned graph.

October 20, 2020
 */

/*
// Definition for a Node.
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
        if (node == null) {
            return null;
        }
        else if (node.neighbors == null
              || node.neighbors.isEmpty()) {
            return new Node(node.val);
        }

        int graphSize = 0;
        HashSet<Integer> nodeVals = new HashSet<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(node);

        // find the amount of nodes in the graph
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (!nodeVals.add(temp.val)) {
                continue;
            }
            graphSize = Math.max(graphSize, temp.val);

            for (Node neighbor : temp.neighbors) {
                if (!nodeVals.contains(neighbor.val)) {
                    stack.push(neighbor);
                }
            }
        }

        // Make an easily accessible array of nodes, both for the existing graph and the copy we will make
        Node[] cloneNodes = new Node[graphSize + 1];
        Node[] graphNodes = new Node[graphSize + 1];

        // loop through the graph again, this time assigning the existing nodes to their corresponding index in the
        // graphNodes array
        stack.push(node);
        nodeVals.clear();
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (!nodeVals.add(temp.val)) {
                continue;
            }

            graphNodes[temp.val] = temp;

            for (Node neighbor : temp.neighbors) {
                if (!nodeVals.contains(neighbor.val)) {
                    stack.push(neighbor);
                }
            }
        }

        // iterate through the size of the cloneNodes array to create each new node for the deep copy
        for (int i = 1; i < graphSize + 1; i++) {
            Node newNode = new Node(i);
            cloneNodes[i] = newNode;
        }

        // iterate again through the size of cloneNodes array to fill the neighbors list for each new node. At this
        // point we're guaranteed to have a valid node at every index
        for (int i = 1; i < graphSize + 1; i++) {
            Node currNode = graphNodes[i];
            for (int j = 0; j < currNode.neighbors.size(); j++) {
                cloneNodes[i].neighbors.add(cloneNodes[currNode.neighbors.get(j).val]);
            }
        }

        return cloneNodes[1];
    }
}