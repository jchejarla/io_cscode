package io.cscode.algorithms.arrays;

public class TrappingRainWater {


    /**
     * Using two temporary arrays capture maximum number on left side and right side for a given element
     * index i
     *
     * Then, compute water that can be trapped as, Min (maxLeft, maxRight) - height[i]
     * Handle the case if the result is less than 0 (if the current height itself if highest)
     *
     * @param height
     * @return
     */
    static int trap_Using_Min_Of_Maxs_Temp_Arrays(int[] height) {

        if(height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = 0;
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i - 1]);
            leftMax[i] = max;
        }

        max = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            rightMax[i] = max;
        }

        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return result;
    }


    /**
     * With the same intution from above solution, since we only need minimum of two maximums on left
     *  and right sides, we don't need the true maximum, just the maximum at that point is good enough.
     *
     * @param height
     * @return
     */
    static int trap_Using_Two_Pointers(int[] height) {

        if(height.length == 0) {
            return 0;
        }

        int l=1;
        int r=height.length-2;

        int leftMax = height[l];
        int rightMax = height[r];

        int result =0;
        while(l<r) {

            if(leftMax < rightMax) {
                l++; // move left pointer
                result += Math.max(0, leftMax - height[l]); // leftMax is already a Min
                leftMax  = Math.max(leftMax, height[l]);// update leftMax for next element
            } else {
                r--; // move right pointer
                result += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("############### Using Min of maximums on left and right side######################");
        System.out.println(trap_Using_Min_Of_Maxs_Temp_Arrays(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

        System.out.println("############### Using two pointers######################");
        System.out.println(trap_Using_Two_Pointers(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
