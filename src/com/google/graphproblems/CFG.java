package com.google.graphproblems;

public class CFG {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge( 0, 1);
        g.addEdge( 0, 4);
        g.addEdge( 1, 2);
        g.addEdge( 1, 3);
        g.addEdge( 1, 4);
        g.addEdge( 2, 3);
        g.addEdge( 3, 4);

        // print the adjacency list representation of
        // the above graph
        //g.printGraph();
        testBFS();
        testDFS();
        testTopologicalSort();
    }

    public static void testBFS(){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }

    public static void testDFS(){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS(2);
    }

    public static void testTopologicalSort(){
        Graph g = new Graph(6);

        g.addDEdge(5, 2);
        g.addDEdge(5, 0);
        g.addDEdge(4, 0);
        g.addDEdge(4, 1);
        g.addDEdge(2, 3);
        g.addDEdge(3, 1);

        g.topologicalSort();
    }
}

