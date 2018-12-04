package com.google;

import java.util.ArrayList;
import java.util.List;

public class ConsecutiveRange {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,4,5,7};
        System.out.println(getConsecutiveRanges(a));
    }
    static List<String> getConsecutiveRanges(int[] a){
        List<String> res = new ArrayList<>();
        int n = a.length;
        int pre = a[0];
        StringBuilder sb = new StringBuilder();
        sb.append(pre + "-");
        for (int i = 1; i < n; i++) {
            if(a[i] - pre == 1){
                sb.append(a[i] + "-");
            } else {
                res.add(sb.toString());
                sb = new StringBuilder();
                sb.append(a[i] + "-");
            }
            pre = a[i];
        }
        res.add(sb.toString());

        return res;
    }
}
