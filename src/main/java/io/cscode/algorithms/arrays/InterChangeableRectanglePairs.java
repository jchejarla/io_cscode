package io.cscode.algorithms.arrays;

import java.util.HashMap;

public class InterChangeableRectanglePairs {

    static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> ratioCount  = new HashMap<>();

        // calculate and store the ratio counts
        for(int[] rectangle: rectangles) {
            double ratio = (double)rectangle[0] / rectangle[1];
            ratioCount.merge(ratio, 1l, Long::sum);
        }

        //calculate pairs for each unique ratio
        //Generic formula for an array of n numbers with k distinct groupings
        // n! / (n-k)! * k!
        int result = 0;
        for(Long uniquePairCount: ratioCount.values()) {
            result += (uniquePairCount * (uniquePairCount -1) ) /2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((double)4/8);
        int[][] rectangles1 = {{4, 8}, {3, 6}, {10, 20}, {15, 30}};
        System.out.println(interchangeableRectangles(rectangles1));
        int[][] rectangles2 = {{4, 5},{7, 8}};
        System.out.println(interchangeableRectangles(rectangles2));

    }
}
