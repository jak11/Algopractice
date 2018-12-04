package com.google;

public class RotateMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        rotate(arr);

    }
    static void rotate(int[][] a){
        printMatrix(a);
        transpore(a);
        printMatrix(a);
        reverseCols(a);
        printMatrix(a);
    }

    private static void printMatrix(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void reverseCols(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < c; i++) {
            for (int j = 0, k = r -1; j < k; j++, k--) {
                int temp = a[j][i];
                a[j][i] = a[k][i];
                a[k][i] = temp;
            }
        }
    }

    private static void transpore(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }



}
