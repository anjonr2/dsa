package com.dsa.recursion;

import java.util.Scanner;

public class BasicRecursion {
    /*recursively printing name from 1 to N*/
    public static void printName(int i,int n){
        if(i>n){
            return;
        }
        System.out.println("test");
        printName(++i,n);
    }
    public static void printNto1(int i, int N){
        if(N<1){
            return;
        }
        System.out.println(N);
        printNto1(i,--N);
    }
    /*print number from 1 to n using backtracking*/
    public static void printNumbers(int i,int n){
        if(i<1){
            return;
        }
        printNumbers(--i,n);
        System.out.println(i);
    }
    /*Print summation of first i numbers using recursion*/
    public static void printSum(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        printSum(i-1,sum+i);
    }
    public static int sum(int n){
        if(n==0) return 0;
        return n+sum(n-1);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of time");
        int count = sc.nextInt();
//        System.out.println("printing name "+count+" times");
//        printName(1,count);

//        System.out.println("printing sum");
//        printNto1(1,count);
//        printSum(count,0);
       int sum =  sum(count);
       System.out.println("sum "+sum);
    }
}
