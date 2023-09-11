package io.cscode.algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class DFS {

    static class Node {
        private int id; // node value
        private LinkedList<Node> adjascencyList = new LinkedList<>();
        public Node(int id) {
            this.id = id;
            lookup.put(id, this);
        }

    }

    static final HashMap<Integer, Node> lookup = new HashMap<>();

    public static boolean dfs(int source, int to) {
        Node sourceNode = lookup.get(source);
        Node toNode = lookup.get(to);
        HashSet<Node> visited = new HashSet<>();
        return dfsRecursive(sourceNode, toNode, visited);
    }

    private static boolean dfsRecursive(Node source, Node dest, HashSet<Node> visited) {
        if(visited.contains(source)){
            return false; // there is no path found
        }

        visited.add(source);

        if(source == dest) {
            return true;
        }

        for(Node adj : source.adjascencyList) {
            if(dfsRecursive(adj, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3
        //      2->6
        //            3->9
        //         6->4

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node six = new Node(6);
        Node nine = new Node(9);
        Node ten = new Node(10);

        one.adjascencyList.add(two);
        one.adjascencyList.add(three);
        two.adjascencyList.add(six);
        three.adjascencyList.add(nine);
        six.adjascencyList.add(four);

        System.out.println(dfs(1, 4));
        System.out.println(dfs(1, 10));

    }
}
