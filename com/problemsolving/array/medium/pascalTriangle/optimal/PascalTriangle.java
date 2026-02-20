package com.problemsolving.array.medium.pascalTriangle.optimal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int rowIdx = 1; rowIdx <= numRows; rowIdx += 1) {
            int ans = 1;
            List<Integer> row = new ArrayList<>();
            row.add(ans);
            // column follows 0th based indexing
            // first column will always be 1, so we start with columnIdx 1
            for (int colIdx = 1; colIdx < rowIdx; colIdx += 1) {
                ans = ans * (rowIdx - colIdx); // for example 2nd row and 1st column is 1 1 * (2-1) = 1
                ans = ans / colIdx;
                row.add(ans);
            }
            triangle.add(row);
        }
        return triangle;
    }
}
