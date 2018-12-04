package com.google.graphproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    int V;
    LinkedList<Integer> adjancyList[];

    public Graph(int v) {
        V = v;
        adjancyList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjancyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        this.adjancyList[u].addFirst(v);
        this.adjancyList[v].addFirst(u);
    }

    public void addDEdge(int u, int v){
        this.adjancyList[u].addFirst(v);
    }

    public void printGraph(){
        for (int i = 0; i < V; i++) {
            System.out.println("Adjaceny List of vertex V = " + i);
            System.out.println("Head");
            for (int j: adjancyList[i]) {
                System.out.print("--> " + j);
            }
            System.out.println(" ");
        }
    }

    public void BFS(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        int temp;

        while (!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp + "-->");
            for (int i: adjancyList[temp]
                 ) {
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void DFS(int s){
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int i: adjancyList[s]
                ) {
            if(!visited[i]){
                DFSUtil(i, visited);
            }
        }
    }

    public void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print( stack.pop() + " -->");
        }
    }

    private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int j: adjancyList[i]
                ) {
            if(!visited[j]){
                topologicalSortUtil(j, visited, stack);
            }
        }
        stack.push(i);
    }

    public void bellmanFord(int src){
        int[] dest = new int[V];
        for (int i = 0; i < V; i++) {
            dest[i] = -1;
        }
    }
}
