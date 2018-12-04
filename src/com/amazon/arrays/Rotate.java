package com.amazon.arrays;

public class Rotate {
    public static void main(String[] args) {
        int[] aar = new int[]{1,2,3,4,5};
        Rotate r = new Rotate();
        r.rotateArr(aar,5,2);
        System.out.println("Result" + aar);
        for (int i = 0; i < aar.length; i++) {
            System.out.println("Result" + aar[i]);
        }
    }

    private void rotateArr(int[] arr, int n, int d){
        reverserArr(arr, 0 , d -1);
        reverserArr(arr, d  , n -1);
        reverserArr(arr, 0 , n -1);
    }

    private void reverserArr(int[] arr, int low, int high){
        int temp;
        while (low < high){
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

}
