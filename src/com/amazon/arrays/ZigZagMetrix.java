package com.amazon.arrays;

public class ZigZagMetrix {
    public static void main(String[] args) {
        int[][] mx = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        printZigzag(mx,4,5);
    }

    static void printZigzag(int[][] mx, int r, int c){
        //for first rowcount diagonal
        for (int i = 0; i < r; i++) {
            for (int row=i, col = 0; row >=0 && col < c; row--, col++){
                System.out.print(mx[row][col] + " ");
            }
            System.out.println("");
        }
        //for first columncount - 1 diagonals
        for (int i = 1; i < c; i++) {
            for (int col=i, row = r - 1; row >=0 && col < c; row--, col++){
                System.out.print(mx[row][col] + " ");
            }
            System.out.println("");
        }
    }
}
