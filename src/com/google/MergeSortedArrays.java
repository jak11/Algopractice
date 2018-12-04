package com.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Map<String,String> mp = new HashMap<>();
        testMap(null);
        int[] a = new int[]{5,8,11,0,0,0};
        int[] b = new int[]{1,9,10};
        int m = 6;
        int n = 3;
        merge(a,m,b,n);
    }
    static void testMap(Map<String,String> m){
       // Optional<String> optionalString = Optional.ofNullable(m).orElse("abcd");
       // System.out.println(optionalString);
    }
    static void merge(int[] a, int m, int[] b, int n){
        int i = 3 ;
        int j = 3 ;

        while (i > 0 && j > 0){
            if(a[i-1] > b[j-1]){
                a[i + j -1] = a[i -1];
                i--;
            } else {
                a[i + j -1] = b[j -1];
                j--;
            }
        }
        while (j > 0){
            a[i+j-1] = b[j-1];
            j--;
        }
        System.out.println("Res" + a);
        for (int k: a){
            System.out.print(" " + k);
        }
    }
}
