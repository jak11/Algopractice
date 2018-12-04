package com.amazon.arrays;

import java.util.ArrayList;

public class SpriralMetrix {
    public static void main(String[] args) {
        int[][] met = new int[][]{
                {1,2,3,4},
                {4,5,6,7},
                {6,7,8,9},
                {10,11,12,13}
        };
        printSprilMetrix(met, 4,4);
    }
    static void  printSprilMetrix(int[][] mx, int m, int n) {
       int T=0;
       int B=m -1;
       int L=0;
       int R=n -1;
       int d = 0;

       while(T <= B && L <= R){
           if(d ==0 ){
               for (int i = L; i <= R; i++) {
                   System.out.print(mx[T][i] + " ");
               }
               T++;
               System.out.println();
           }else if(d ==1){
               for (int i = T; i <= B; i++) {
                   System.out.print(mx[i][R] + "  ");
               }
               R--;
               System.out.println();
           }else if(d ==2){
               for (int i = R; i >= L; i--) {
                   System.out.print(mx[B][i] + " ");
               }
               B--;
               System.out.println();
           }else if(d ==3){
               for (int i = B; i >= T; i--) {
                   System.out.print(mx[i][L] + " ");
               }
               L++;
               System.out.println();
           }
           d =(d + 1)%m;
       }
    }
}
