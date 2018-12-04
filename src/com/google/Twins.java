package com.google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Twins {
    public static void main(String[] args) {
       int[] a = {1,2,2,2,4,4,4,4,4,4,5,5,5,5,5,7,7,8,8,8,8,8,8,8};
        System.out.println(getNthRepeatingNum(a, 2));
    }

    public static int getNthRepeatingNum(int[] a, int n){
        Map<Integer, Integer> map = new HashMap<>();

        for (int anA : a) {
            if (map.containsKey(anA)) {
                map.put(anA, map.get(anA) + 1);
            } else {
                map.put(anA, 1);
            }
        }

        Queue<Pair> pq = new PriorityQueue<>((x, y) -> y.getFrequency() - x.getFrequency());

        map.forEach((integer, integer2) -> pq.add(new Pair(integer, integer2)));

        for (int i = 0; i < n - 1; i++) {
            pq.poll();
        }
        return pq.poll().getValue();
    }



}

class Pair {
    public int value;
    public int frequency;

    public int getValue() {
        return value;
    }

    public int getFrequency() {
        return frequency;
    }

    public Pair(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}
