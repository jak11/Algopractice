package com.google;

import java.util.HashSet;
import java.util.Set;

public class MagicStrings {
    private static final int MAX_CHAR = 26;

    public static void main(String[] args) {
        System.out.println(encodeString("abcd".toCharArray()));
        String input[] = {"abcd", "acbd", "adcb", "cdba",
                "bcda", "badc"};
        Set<String> set = new HashSet<>();
        int count =0;
        for (String s : input){
            String tmp =  encodeString(s.toCharArray());
            if(!set.contains(tmp)){
                set.add(tmp);
                count++;
            }
        }

        System.out.println(count);

    }

    static String encodeString(char[] str) {
        // hashEven stores the count of even indexed character
        // for each string hashOdd stores the count of odd
        // indexed characters for each string
        int hashEven[] = new int[MAX_CHAR];
        int hashOdd[] = new int[MAX_CHAR];

        // creating hash for each string
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if ((i & 1) != 0) // If index of current character is odd
                hashOdd[c-'a']++;
            else
                hashEven[c-'a']++;

        }


        // For every character from 'a' to 'z', we store its
        // count at even position followed by a separator,
        // followed by count at odd position.
        String encoding = "";
        for (int i = 0; i < MAX_CHAR; i++) {
            encoding += (hashEven[i]);
            encoding += ('-');
            encoding += (hashOdd[i]);
            encoding += ('-');
        }
        return encoding;
    }
}
