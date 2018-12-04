package com.amazon.arrays;

import java.util.HashMap;
import java.util.Map;

public class TeString
{
    public static void main(String[] args)
    {
        String s = "1234111";
        System.out.println(s);

        for (char c:s.toCharArray()){
            System.out.println(c);
        }

        System.out.println(Integer.parseInt(s));
        Custom c = new Custom();
        Custom c1 = new Custom();
        Custom c2 = new Custom();
        c.i = 1;
        c1.i = 2;
        c2.i = 2;

        Map<Custom, String> map = new HashMap<>();
        map.put(c, "1");
        map.put(c1, "12");
        map.put(c2, "13");
        System.out.println(map.size());
        System.out.println(map.get(c2));
    }

    static class Custom {
        int i;
        int j;
        String name;


        @Override
        public int hashCode()
        {
            int result = i;
            result = 31 * result + j;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}
