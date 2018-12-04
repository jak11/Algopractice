package com.amazon.strings;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(toInt("-12345"));
    }
    public static int toInt(String str){
        int sum = 0;
        boolean isNagetive = false;
        if(str.charAt(0) == '-'){
            isNagetive = true;
        }
        char[] chars = str.toCharArray();


        int asciZero = (int)'0';

        for (int i = 1;i < chars.length; i++) {
            int tempasci = (int)chars[i];
            sum = (sum*10) + (tempasci - asciZero);
        }


        return isNagetive? sum = -sum: sum;
    }
}
