package com.dsa.array;

import java.util.ArrayList;

public class PrintPascalTriangle {
    public static ArrayList<Long> generateRow(int row) {
        ArrayList<Long> ansRow = new ArrayList<>();
        Long ans = 1L;
        ansRow.add(ans);
        if (row == 1) {
            return ansRow;
        }
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
    }

    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> pascalTriangle = new ArrayList<>();
        for (int row = 1; row <= n; row++) {
            ArrayList<Long> temp = generateRow(row);
            pascalTriangle.add(temp);
        }
        return pascalTriangle;
    }
}
