package io.cscode.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /* simple solution to use previous row values*/
    static List<List<Integer>> usingPreviousRowValues (int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if(numRows == 1) {
            return result;
        }

        // then add second row as well
        result.add(List.of(1, 1));
        for(int i=2; i<numRows; i++) {
            List<Integer> previousRow = result.get(i-1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            for(int j=1; j<i; j++) {
                currentRow.add(previousRow.get(j-1) + previousRow.get(j));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(usingPreviousRowValues(5));
    }
}
