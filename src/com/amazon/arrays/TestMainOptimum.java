package com.amazon.arrays;

public class TestMainOptimum
{
    public static void main(String[] args)
    {
        int val[] = new int[]{20, 19};
        int wt[] = new int[]{24, 20};
        int n = 3;
        int x[] = new int[n+1];
        int W = 50;
        int i = 1;

        int weight = 0;
        while (i <= n && weight < W){
            if(weight + wt[i] <= W){
                x[i] = 1;
            }else {
                x[i] = (W - weight)/wt[i];
                weight = weight + x[i]*wt[i];
            }
            i++;
        }

        System.out.println(weight);
    }
}
