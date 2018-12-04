package com.google;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumOfSizeK {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k =3;
        printMaxSubArraysOfSizek(a,k);
    }
    public static void printMaxSubArraysOfSizek(int a[], int k){
        Queue<Integer> q = new PriorityQueue<>(4, Collections.reverseOrder());

        for (int i =0; i <= a.length - k ; i++){
            for( int j = i; j < i+ k;j++){
                q.add(a[j]);
            }
            System.out.println("largest element" + q.peek());
            q.clear();
        }
    }
}
