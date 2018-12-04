package com.amazon.arrays;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LookSay{
//    public static void main(String [] args){
//        System.out.println("*********"+lookAndSay("11", 1) );
//    }
   // private static String lookAndSayV2(final String number, final int position)	  {	    /* @formatter:off */	    return number.length() == position ?	              String.valueOf(number	                            .length()) +	                number.charAt(0) :	              (number.charAt(0) == number.charAt(position) ?	                  lookAndSayV2(number, position + 1) :	                  String.valueOf(number	                                .substring(0, position)	                                .length()) +	                    number.charAt(0) +	                    lookAndSayV2(number	                              .substring(position), 0));	    /* @formatter:on */	  }

//    public static String lookAndSay(String start,int sequenceNumber) {
//        if (sequenceNumber <= 0)
//            return null;
//
//        String output = start;
//        int i = 0;
//
//        while (i < sequenceNumber) {
//            StringBuilder stringBuilder = new StringBuilder();
//            int count = 1;
//            for (int j = 1; j < output.length(); j++) {
//                if (output.charAt(j) == output.charAt(j - 1)) {
//                    count++;
//                } else {
//                    stringBuilder.append(count);
//                    stringBuilder.append(output.charAt(j - 1));
//                    count = 1;
//                }
//            }
//
//            stringBuilder.append(count);
//            stringBuilder.append(output.charAt(output.length() - 1));
//            output = stringBuilder.toString();
//            i++;
//        }
//
//        return output;
//    }

    /// to convert to base 7 from given base 10
    public static String convert(long _in) {
        char [] base7={'0','S','y','d','n','e','y'};
        StringBuffer target=new StringBuffer();

        for (long i=_in; i>0; i /=7){
            target.append(base7[(int)i%7]);
        }

        target= target.reverse();
        return target.toString();
    }

    public static void main (String[] args) throws Exception {
        long _in=7;
     //   _in=16807+2401*2+343*3+49*4+7*5+1*6;
        System.out.println(convert(_in));
        Map<String,String> t = new HashMap<>();
        int i = 556;

    }
}

