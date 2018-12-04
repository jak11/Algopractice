package com.amazon.arrays;

import java.util.Stack;

public class JAatest
{
    public static void main(String[] args)
    {
        String s = "aabc";
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        int i=0;
            while(s.charAt(i) != 'X') {
                stack.push(s.charAt(i));
                i++;
            }

        i++;
        while (i < s.length()){
            if(stack.isEmpty()){
                result = false;
                break;
            }

            if(s.charAt(i) != stack.pop()){
                result =false;
                break;
            }
            i++;
        }


            System.out.println("Ispalindrome : " + result);


    }


}
