package io.cscode.algorithms.arrays;

public class RangeSumQuery2DImmutable {


    private final int[][] prefixSumArray;


    /**
     * Will do the pre-computation, i.e. compute prefix array.
     */
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            prefixSumArray = null;
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        prefixSumArray = new int[m+1][n+1]; // additional row and column with 0's

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                prefixSumArray[i][j] = matrix[i-1][j-1] // current element from input array
                        + prefixSumArray[i-1][j] // row above, same column
                        + prefixSumArray[i][j-1] // column to left, same row
                        - prefixSumArray[i-1][j-1]; // diagonal element in prefixSumArray,
                                                // since it was double counted in row sum and column sum
            }
        }
       /* for(int[] nums: arr) {
            System.out.println(Arrays.toString(nums));
        }*/
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(prefixSumArray == null) {
            return 0;
        }
        int row2Col2Corner = prefixSumArray[row2 + 1][col2 + 1]; // +1 is because arr has additional row and column
        int aboveRowCol2 = prefixSumArray[row1][col2 + 1];
        int previousCol1Row2 = prefixSumArray[row2+1][col1];
        int diagonalRowColumn = prefixSumArray[row1][col1];
        return row2Col2Corner - (aboveRowCol2 + previousCol1Row2)  + diagonalRowColumn ;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {3, 0, 1, 4, 2},
                            {5, 6, 3, 2, 1},
                            {1, 2, 0, 1, 5},
                            {4, 1, 0, 1, 7},
                            {1, 0, 3, 0, 5}
                        };
        RangeSumQuery2DImmutable rangeSum2D = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rangeSum2D.sumRegion(2,1, 4,3));
        System.out.println(rangeSum2D.sumRegion(1,1, 2,2));
        System.out.println(rangeSum2D.sumRegion(1,2, 2,4));
    }
}
