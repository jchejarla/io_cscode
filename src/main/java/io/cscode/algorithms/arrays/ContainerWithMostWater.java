package io.cscode.algorithms.arrays;

public class ContainerWithMostWater {

    static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left); // to avoid overflow
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++  ;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));

    }
}
