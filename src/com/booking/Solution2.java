package com.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import sun.jvm.hotspot.utilities.Interval;

public class Solution2 {
    public static void main(String[] args) {

        List<List<String>> image = new ArrayList<>();
        List<String> c1 = new ArrayList<>();
        c1.add("red");
        c1.add("green");
        c1.add("red");
        image.add(c1);
        System.out.println(topColor(image));
    }



    private  static class Color {
        String color;
        int freq;

        @Override
        public String toString() {
            return "Color{" +
                    "color='" + color + '\'' +
                    ", freq=" + freq +
                    '}';
        }

        public Color(String color, int freq) {
            this.color = color;
            this.freq = freq;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }

        public static List<String> topColor(List<List<String>> image) {
            // TODO change me!
            Map<String, Integer> colorMap = new HashMap<>();
            for (List<String> list : image) {
                for (String color: list
                     ) {
                    if(colorMap.containsKey(color)) {
                        colorMap.put(color, colorMap.get(color) + 1);
                    }
                    else {
                        colorMap.put(color, 1);
                    }

                }
            }

            List<Color> res = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : colorMap.entrySet()) {
                res.add(new Color(entry.getKey(), entry.getValue()));
            }
            System.out.println(res);
            res.sort(new Comparator<Color>() {
                @Override
                public int compare(Color o1, Color o2) {
                    return o2.getFreq() - o1.getFreq();
                }
            });
            System.out.println(res);
            List<String> result = new ArrayList<>();
            int maxVal = res.get(0).getFreq();
            for(int i = 0 ; i < res.size(); i++)
                if(maxVal == res.get(i).getFreq()){
                    result.add(res.get(i).getColor());
                }
            return result;
        }

}
