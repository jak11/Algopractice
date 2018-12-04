package com.google;

import java.util.Arrays;
import java.util.List;

public class SortingOrder {
    public static void main(String[] args) {
        hammingDistance(4,5);
    }
    public static int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        System.out.println(s1 + "-->" + s2);
        int len = 0;
        if(s1.length() > s2.length()){
            len = s1.length();
        } else {
            len = s2.length();
        }


        return -1;
    }
}
