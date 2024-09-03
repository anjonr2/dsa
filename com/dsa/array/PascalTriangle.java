package com.dsa.array;

public class PascalTriangle {
    // given row no print that entire row
    public static int[] printRow(int rowNo) {
        // nth row will have nth no of coln
        // first col will always have value 1
        int ans = 1;
        int res[] = new int[rowNo];
        int idx = 0;
        res[idx] = ans;
        idx += 1;
        // considering zero based indexing for columns
        for (int col = 1; col < rowNo; col++) {
            ans = ans * (rowNo - col);
            ans = ans / col;
            res[idx] = ans;
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = printRow(6);
        System.out.println("Pascals triange " + 6 + "th row ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
