package com.google.graphproblems;

public class DIjkstras {
    public static void main(String[] args) {
        int[][] dis = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        printShotestDis(dis, 0);
    }

    static void printShotestDis(int[][] g, int src){
        int V = g.length;
        int[] mindis = new int[V];
        boolean[] sptSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            mindis[i] = Integer.MAX_VALUE;
        }

        //sptSet[src] = true;
        mindis[src] = 0;
        for (int i = 0; i < V; i++) {
            System.out.println(sptSet[i]);
        }


        for (int i = 0; i < V; i++) {
            int u = findMinDistanceNode(sptSet, mindis);
            System.out.println("u -->"+ u);
            //if(u != -1){
                sptSet[u] = true;
                for (int j = 0; j < V; j++) {
                    if(!sptSet[j] && g[u][j] !=0 && mindis[u] != Integer.MAX_VALUE && mindis[j] > g[u][j] + mindis[u]){
                        mindis[j] = g[u][j] + mindis[u];
                    }
                }
          // }
        }

        for (int i = 0; i < mindis.length; i++) {
            System.out.println(" src "+i + " " + mindis[i]);
        }



    }

    private static int findMinDistanceNode(boolean[] sptSet, int[] mindis) {
        int min = Integer.MAX_VALUE;
        int minV = -1;
        for (int i = 0; i < mindis.length; i++) {
            if(mindis[i] <= min && !sptSet[i]){
                min = mindis[i];
                minV = i;
            }
        }
        return minV;
    }
}
