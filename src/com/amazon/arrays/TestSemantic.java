package com.amazon.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSemantic
{

    class Store implements Comparable {
        public int weight;
        public int val;

        @Override
        public boolean equals(Object o)
        {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Store store = (Store) o;

            if (weight != store.weight) {
                return false;
            }
            return val == store.val;
        }

        @Override
        public int hashCode()
        {
            int result = weight;
            result = 31 * result + val;
            return result;
        }

        @Override
        public int compareTo(Object o)
        {
            Store in = (Store) o;
           if(this.weight < in.weight){
               return 1;
           }else if(this.weight == in.weight){
               return 0;
           } else {
               return -1;
           }
        }

        @Override
        public String toString()
        {
            return "Store{" +
                    "weight=" + weight +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args)
    {
        getAllSubsequences("xyz");
        System.out.println(set);

        int val[] = new int[]{20, 19};
        int wt[] = new int[]{24, 20};











        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(knapSack1(W, wt, val, n));
    }

    public void test(){

        int val[] = new int[]{20, 19};
        int wt[] = new int[]{24, 20};
        List<Store> stores = new ArrayList<>();

        System.out.println();
        for (int i = 0; i < val.length; i++) {
            Store s = new Store();
            s.val = val[i];
            s.weight = wt[i];
            stores.add(s);
        }

        Collections.sort(stores);



    }


    static HashSet<String> set = new HashSet<>();


    static void getAllSubsequences(String str)
    {

        for (int i = 0; i < str.length(); i++) {

            for (int j = str.length(); j > i; j--) {
                String subSeq = str.substring(i, j);

                if (!set.contains(subSeq))
                    set.add(subSeq);

                for (int k = 1; k < subSeq.length() - 1; k++) {
                    StringBuffer sb = new StringBuffer(subSeq);

                    sb.deleteCharAt(k);
                    if (!set.contains(sb))
                        ;
                    getAllSubsequences(sb.toString());
                }
            }
        }
    }




        // A utility function that returns maximum of two integers
        static int max(int a, int b) { return (a >= b)? a : b; }

        // Returns the maximum value that can be put in a knapsack of capacity W
        static int knapSack(int W, int wt[], int val[], int n)
        {
            int i, w;
            int K[][] = new int[n+1][W+1];

            // Build table K[][] in bottom up manner
            for (i = 0; i <= n; i++)
            {
                for (w = 0; w <= W; w++)
                {
                    if (i==0 || w==0)
                        K[i][w] = 0;
                    else if (wt[i-1] <= w)
                        K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                    else
                        K[i][w] = K[i-1][w];
                }
            }

            return K[n][W];
        }

    static int knapSack1(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                knapSack1(W, wt, val, n-1)
        );
    }

}
