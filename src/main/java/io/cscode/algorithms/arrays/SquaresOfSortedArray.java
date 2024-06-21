package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class SquaresOfSortedArray {

    static int[] sortedSquares(int[] nums) {

        int[] output = new int[nums.length];
        int left =0;
        int right=nums.length-1;
        for(int i=output.length-1;i>=0;i--) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                output[i] = nums[left] * nums[left];
                left++;
            } else {
                output[i] = nums[right] * nums[right];
                right--;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}
