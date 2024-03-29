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
    public static boolean checkPalindrome(String str){
        if(str.length()==0 || str.length()==1) return true;
        int i=0;
        if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        i= i+1;
        if(i>=str.length()/2) return true;
        /*in recursive function call passing the substring of the original string
        * excluding first and last character everytime*/
        return checkPalindrome(str.substring(1,str.length()-1));
    }
    public static int NthFibbonacci(int n){
        if(n<=1) return n;
        return NthFibbonacci(n-1)+NthFibbonacci(n-2);
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

        String str = "ABCD";
        System.out.println("Given string is Palindrome "+checkPalindrome(str));

        int n= NthFibbonacci(3);
        System.out.println("3rd fibbonacci number "+n);
    }
}
