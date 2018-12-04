package com.flipkart;

import java.util.ArrayList;
import java.util.Arrays;

public class TestReplace {
    public static void main(String[] args) {
        testRpl();
        testRpl();
    }
    static void testRpl() {
        ArrayList<String> l = new ArrayList<>(Arrays.asList("AB","A","AA"));
        l.replaceAll(x -> "b" + x);
        System.out.println(l);
    }
}
