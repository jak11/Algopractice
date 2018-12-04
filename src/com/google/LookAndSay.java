package com.google;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LookAndSay {
    public static void main(String[] args) {
        getNthLookAndSay(2);
    }

    static int getNthLookAndSay(int n){
        String f1 = "1";
        if(n == 1){
            return Integer.parseInt(f1);
        }

        int c = 1;
        String f2 = null;
        while (c <= n){
            f2 = getTerm(f1);
            f1 = f2;
            c++;
        }
        System.out.println(f2);
        return -1;
    }

    private static String getTerm(String f1) {
        Map<Integer, Integer> cmap = new LinkedHashMap<>();
        int digit;
        for (int i = 0; i < f1.length(); i++) {
            digit = Character.getNumericValue(f1.charAt(i));
            if(cmap.containsKey(digit)) {
                cmap.put(digit, cmap.get(digit) + 1);
            } else {
                cmap.put(digit,  1);
            }
        }

        //System.out.println(cmap);

        StringBuilder sb = new StringBuilder();
        cmap.forEach((integer, integer2) -> {
            sb.append(integer).append(integer2);
        });
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
