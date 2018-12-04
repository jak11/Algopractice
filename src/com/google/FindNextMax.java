package com.google;

import java.util.Arrays;
import java.util.Optional;

public class FindNextMax {
    public static void main(String[] args) {
        Optional<String> testStr = Optional.empty();
        System.out.println(testStr.get());
        System.out.println("Next max -->"+ getNextMax(534976));
        int cost[][]= {{1, 2, 3},
            {4, 8, 2},
            {1, 5, 3}};
        minCost(cost,2,2);
    }
    private static int minCost(int cost[][], int m, int n)
    {

        int i, j;
        int tc[][]=new int[m+1][n+1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = Math.min(tc[i-1][j-1], Math.min(tc[i-1][j],
                        tc[i][j-1])) + cost[i][j];



        for (i = 0; i <= m; i++){
            for (j = 0; j <= n; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println();
        }


        return tc[m][n];
    }
    private static int getNextMax(int n){
        String str = Integer.toString(n);
        int l = str.length();
        int index = -1;
        char[] chars = str.toCharArray();
        for (int i = l -1; i > 0 ; i--) {
            if(chars[i-1] < chars[i]){
                index = i -1;
                break;
            }
        }

        if(index == -1) {
            return -1;
        }else {
            int x = chars[index], min = index;

            for (int j = index + 1; j < l;j++){
                if(chars[j] > x && chars[j] < chars[min]){
                    min = j;
                }
            }

            int temp = chars[index];
            chars[index] = chars[min];
            chars[min] = (char) temp;

            Arrays.sort(chars, index + 1, chars.length -1);

            for (int i = 0; i < l; i++)
                System.out.print(chars[i]);
        }
        return -1;
    }
}
