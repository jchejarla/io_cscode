package io.cscode.algorithms.graph;

import java.util.*;

public class BFS {

    static class Node {
        int id; // node value
        LinkedList<Node> adjacencyList = new LinkedList<>();
        public Node(int id) {
            this.id = id;
        }
    }

    static final HashMap<Integer, Node> lookup = new HashMap<>();

    static boolean bfs(int from, int to) {
        Node fromNode = lookup.get(from);
        Node toNode = lookup.get(to);

        HashSet<Node> visited = new HashSet<>();// to keep track of visited vertexes
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(fromNode);

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n == toNode) {
                return true;
            }
            Node next = n.adjacencyList.peek();

        }

        return false;
    }
}
