package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class MinimumDiffBetweenHighestAndLowestOfKScores {

    static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left =0;
        int right = k-1; // kth index
        int min  = Integer.MAX_VALUE;
        while(right<nums.length) { // because right index will reach end of array first
            int window = nums[right] - nums[left];
            if(window < min) {
                min = window;
            }
            left++;
            right++;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] {90}, 1));
        System.out.println(minimumDifference(new int[] {9,4,1,7}, 2));
    }
}
