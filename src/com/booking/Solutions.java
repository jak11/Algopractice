package com.booking;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public static void main(String[] args) {
        int[] arr = new int[] {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
        printDelta(arr);
    }

    private static void printDelta(int[] a) {
        int n = a.length;
        List<Integer> res = new ArrayList<>();
        int diff =0;
        res.add(a[0]);
        for (int i = 1; i < n; i++) {
            diff = a[i] - a[i-1];
            if(diff >= 127 || diff <= -127){
                res.add(-128);
            }
            res.add(diff);
        }
        System.out.println(res);
    }
}
