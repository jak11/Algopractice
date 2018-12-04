package com.google;

public class TargetSum {
    public static void main(String[] args) {
        int[] aar = new int[]{-2,-3,7,2,1};
        System.out.println(sumExists(aar,4));
    }
    private static boolean sumExists(int[] arr, int x){
        if(arr == null) {
            return false;
        }

        int currentsum = 0 ;
        int j =0;

        for (int i = 0; i < arr.length; i++) {
            if(currentsum > x){

                while (currentsum > x && j < i){
                    currentsum-=arr[j];
                    j++;
                }
            }

            if(currentsum == x){
                return true;
            }
            currentsum = currentsum + arr[i];

        }

        return false;
    }
}
