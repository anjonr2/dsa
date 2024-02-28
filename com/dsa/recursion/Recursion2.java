package com.dsa.recursion;

public class Recursion2 {
    public static void reverseArr(int []arr, int leftIndex, int rightIndex){
        if(rightIndex<leftIndex) return;
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[rightIndex];
        arr[rightIndex]=temp;
        reverseArr(arr,leftIndex+1,rightIndex-1);
    }
    public static void reverse(int []arr,int i,int n){
        if(i>=n/2) return;
        /*do the swapping*/
        int temp = arr[i];
        arr[i]=arr[n-i-1];
        arr[n-i-1]=temp;
        reverse(arr,i+1,n);
    }
    public static void main(String []args){
        int arr[] = {3,9,6,4,5};
        System.out.println("After reversing the array "+arr);
        reverseArr(arr,0,arr.length-1);
        for(int el : arr){
            System.out.print(" "+el+" ");
        }
        System.out.println("Reverse array process 2: ");
        reverse(arr,0,5);
        for(int el : arr){
            System.out.print(" "+el+" ");
        }
    }
}
