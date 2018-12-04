package com.amazon.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pairs
{
    public static void main(String[] args)
    {   int arr[] = new int[]{1, 3, 46,1,3,9,47};
        //System.out.println(getPairsCount(arr,6,47));

        String[] temp = new String[2];
        temp[0] = "000000001111111100000000";


        System.out.println("res" + getcolors(temp));
    }



    static String[] getcolors(String[] temp){

        String[] nearest = new String[temp.length];
        //String temp;
        for (int i = 0; i < temp.length; i++) {
            nearest[i] = getDistance(temp[i]);
            System.out.println(nearest[i]);
        }
        return nearest;
    }

    static String getDistance(String color){
        if(color == null){
            return null;
        }

        String s1 = color.substring(0,8);
        String s2 = color.substring(8,16);
        String s3 = color.substring(16,24);
        System.out.println(s1 + " " + s2 + "  " + s3);


        int r=Integer.parseInt(s1,2);
        int g=Integer.parseInt(s2,2);
        int b=Integer.parseInt(s3,2);

        System.out.println(r);
        System.out.println(g);
        System.out.println(b);

        Color input = new Color(r,g,b,"INPUT");

        Color black = new Color(0,0,0, "BLACK");
        Color white = new Color(255,255,255, "WHITE");
        Color red = new Color(255,0,0,"RED");
        Color green = new Color(0,255,0, "GREEN");
        Color blue = new Color(0,0,255, "BLUE");

        List<Color> colors = new ArrayList<>();
        colors.add(black);
        colors.add(white);
        colors.add(red);
        colors.add(green);
        colors.add(blue);

        Color temp;
        double max = Double.MAX_VALUE;



        String res = null;
        for (int i = 0; i < colors.size(); i++) {
            temp = colors.get(i);
            double d = Math.sqrt(
                    Math.pow((temp.r - input.r), 2)  +
                            Math.pow((temp.g - input.g), 2) +
                            Math.pow((temp.b - input.b), 2));

            if(d < max){
                max = d;
                res = temp.name;
            }
        }

        return res;
    }

    public static class Color
    {
        public int r;
        public int g;
        public int b;
        public String name;

        public Color(int r, int g, int b, String name)
        {
            this.r = r;
            this.g = g;
            this.b = b;
            this.name = name;
        }
    }

}
