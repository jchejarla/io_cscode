package io.cscode.algorithms.arrays;

public class GridGame {



    static long gridGame(int[][] grid) {

        long topRowSum = 0;
        for(int i=0; i<grid[0].length; i++) {
            topRowSum += grid[0][i];
        }
        long bottomSum = 0;
        long result = Long.MAX_VALUE;


        for(int i=0; i<grid[0].length; i++) {
            topRowSum = topRowSum - grid[0][i]; // remaining sum, what is left for second robot to collect
                                                // after current element is taken by first robot
                                               // Idea here is, once the robot is moved to second row, it cannot go back.
                                              // So, if first robot come down to second row at i(th) position,
                                            // sum left for second row is [total sum of 1st row] - current element


            result = Math.min(result, Math.max(bottomSum, topRowSum)); //
            bottomSum += grid[1][i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1,15}, {1,3,3,1}};
        System.out.println(gridGame(grid));
    }
}
