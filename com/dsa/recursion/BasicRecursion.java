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
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of time");
        int count = sc.nextInt();
//        System.out.println("printing name "+count+" times");
//        printName(1,count);

        System.out.println("printing number N to 1");
        printNto1(1,count);
    }
}
