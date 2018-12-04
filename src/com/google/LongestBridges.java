package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class LongestBridges {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + getLIS( arr) + " n" );
        List<Pair<Integer,Integer>> cities = new ArrayList<>();

        cities.add(new Pair<>(5,6));
        cities.add(new Pair<>(3,4));
        cities.add(new Pair<>(10,1));
       // cities.add(new Pair<>(3,2));

        cities.sort(Comparator.comparing(Pair::getValue));

        System.out.println(cities);

        int[] southpoints = cities.stream().mapToInt(Pair::getKey).toArray();

        System.out.println("Length of lis is " + getLIS( southpoints ) + " n" );
        int longestB = getLongestBridge();
    }

    private static int getLongestBridge() {

        return 0;
    }

    private static int getLIS(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j] + 1){
                    lis[i] = lis[j]+1;
                }
            }
        }
        int max = lis[0];
        for (int i = 1; i < n; i++) {
            if(lis[i] > max){
                max = lis[i];
            }
        }
        return max;
    }
}
