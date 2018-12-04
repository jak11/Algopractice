package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntersectionArray {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        int[] b = new int[]{2,3,4,5};
        System.out.println(getArrayIntersection(a,b));
    }
    private static List<Integer> getArrayIntersection(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        if(a == null && b != null){
            return IntStream.of(b).boxed().collect(Collectors.toList());
        }

        if(b == null && a != null){
            return IntStream.of(a).boxed().collect(Collectors.toList());
        }
        int l1 = a.length;
        int l2 = b.length;
        Set<Integer> store = new HashSet<>();

        for (int i: a) {
            store.add(i);
        }

        for (int i:b ) {
            if(store.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
