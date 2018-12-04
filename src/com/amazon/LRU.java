package com.amazon;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LRU {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        int[] input= new int[]{1,2,3,1,4,5,6};
        Map<Integer,Integer> cacheStore = new HashMap<>();
        for (int i: input) {
            System.out.println("QUEUE :" + q);
            if(q.size() < 3){
                q.add(i);
            }else {
                if(q.contains(i)){
                    q.remove(i);
                    q.add(i);
                }else {
                    q.remove();
                    q.add(i);
                }
            }
        }
        String key = "key1";
        byte ptext[] = new byte[0];
        try {
            ptext = key.getBytes("ISO-8859-1");
            String value = new String(ptext, "UTF-8");
            System.out.println(value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        System.out.println("curspor" + "Cusrsor:0".split(":")[1]);
    }
}
