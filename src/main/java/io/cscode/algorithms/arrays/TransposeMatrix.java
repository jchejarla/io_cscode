package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class TransposeMatrix {

    static int[][] transposeMatrix(int[][] matrix) {
        if(matrix == null) {
            return null;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = transposeMatrix(new int[][] {{1,2}});
        Stream.of(result).forEach(row->System.out.println(Arrays.toString(row)));
        result = transposeMatrix(new int[][] {{1,2}, {3,4}, {5,6}});
        Stream.of(result).forEach(row->System.out.println(Arrays.toString(row)));
        result = transposeMatrix(new int[][] {{}});
        Stream.of(result).forEach(row->System.out.println(Arrays.toString(row)));
    }
}
