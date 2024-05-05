package io.cscode.algorithms.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> indexToHeight = new Stack<>(); // monotonically increasing order
        for(int i=0; i<heights.length; i++) {
            int startIndex = i;
            int height = heights[i];
            while(!indexToHeight.isEmpty() && indexToHeight.peek()[1] > height) {
                // if top of the stack height is greater than current one, then we cannot extend previous height
                int[] indexHeight = indexToHeight.pop();
                int indexE = indexHeight[0];
                int heightE = indexHeight[1];
                maxArea = Math.max(maxArea , ((i - indexE) * heightE));
                startIndex = indexE;
            }
            indexToHeight.push(new int[]{startIndex, height});
        }

        // in the above loop, it may not have computed maxArea if the array is in increasing order
        for(int[] indexHeight : indexToHeight) {
            maxArea = Math.max(maxArea, indexHeight[1] * (heights.length - indexHeight[0]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{2,4}));

    }
}
