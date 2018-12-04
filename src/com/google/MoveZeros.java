package com.google;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 0, 12,1,0, 5, 0};
        System.out.println(moveZerosEnd(arr,10));
        for (int a : arr){
            System.out.print(a + " ");
        }
    }
    public static int[] moveZerosEnd(int[] a, int n){
        int i = 0, j = n-1, temp;
        while (i < j){
            if(a[j] == 0) {
                j--;
                continue;
            }
            if(a[i] == 0) {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j--;
            }
            i++;
        }
        return a;
    }
}
