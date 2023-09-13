package io.cscode.algorithms.dp;

import java.util.List;

public class TriangleMinPathSum {

    /* brute-force depth first search using recursion */
    static int minimumTotal(List<List<Integer>> triangle) {
       return minimumTotalBruteforce(triangle, 0, 0);
    }

    static int minimumTotalBruteforce(List<List<Integer>> triangle, int row, int column) {

        if(row == triangle.size()) {// when we reach end row
            return 0;
        }
        int currentNumber = triangle.get(row).get(column);
        return Math.min(currentNumber + minimumTotalBruteforce(triangle, row +1, column),
                currentNumber + minimumTotalBruteforce(triangle, row +1, column+1));
    }

    /* using dynamic programming and memoization */
    static int minimumTotalDp(List<List<Integer>> triangle) {
        int[] temp = new int[triangle.get(triangle.size()-1).size()+1];
        for(int i= triangle.size() -1; i>=0; i--) { // start from last row bottom-up
            List<Integer> row = triangle.get(i);
            for(int j=0; j<row.size(); j++){
                temp[j] = Math.min(row.get(j)+temp[j], row.get(j)+temp[j+1]);
            }
        }
        return temp[0];
    }

    public static void main(String[] args) {
        System.out.println("### Using Depth First search - recursion ### ");
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(minimumTotalDp(List.of(List.of(-11))));

        System.out.println("### Using dynamic programming ### ");
        System.out.println(minimumTotalDp(List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))));
        System.out.println(minimumTotalDp(List.of(List.of(-11))));

    }

}
