package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void printSubSequence(int idx, ArrayList<Integer> list, int []inputArr){
        if(idx==inputArr.length){
            printArr(list);
            if(list.size()==0){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        //picked element at idx
        list.add(inputArr[idx]);
        printSubSequence(idx+1,list,inputArr);

        //backtrack and remove element from the last idx
        list.remove(list.size()-1);
        printSubSequence(idx+1,list,inputArr);
    }
    public static void printArr(ArrayList<Integer> list){
        for(int e : list){
            System.out.print(" "+e+" ");
        }
    }
    public static void main(String [] args){
        int []a = {3,1,2};
        ArrayList<Integer> list = new ArrayList<Integer>();
        printSubSequence(0,list,a);
    }
}
