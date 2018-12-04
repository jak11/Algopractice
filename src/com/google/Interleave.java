package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Interleave {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        int[] arr1 = new int[] {1,2,3};
        int[] arr2 = new int[] {9,0};
        int[] arr3 = new int[] {5};
        int[] arr4 = new int[] {-4,-5,-2,-3,-1};

        List<Integer> l1 = IntStream.of(arr1).boxed().collect(Collectors.toList());
        List<Integer> l2 = IntStream.of(arr2).boxed().collect(Collectors.toList());
        List<Integer> l3 = IntStream.of(arr3).boxed().collect(Collectors.toList());
        List<Integer> l4 = IntStream.of(arr4).boxed().collect(Collectors.toList());

        input.add(l1);
        input.add(l2);
        input.add(l3);
        input.add(l4);

       /* input.add( new ArrayList<Integer>(Arrays.asList(arr2)));
        input.add( new ArrayList<Integer>(Arrays.asList(arr3)));
        input.add( new ArrayList<Integer>(Arrays.asList(arr4)));*/

        System.out.println(getInterleaveList(input));

    }
    static List<Integer> getInterleaveList(List<List<Integer>>  input){
        List<Integer> res = new ArrayList<>();

        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (List<Integer> list: input ) {
            for (int i = 0; i < list.size(); i++) {
                if(map.containsKey(i)){
                    map.get(i).add(list.get(i));
                } else {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(list.get(i));
                    map.put(i, list1);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry:  map.entrySet() ) {
            res.addAll(entry.getValue());
        }

        return res;
    }
}
