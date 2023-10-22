package io.cscode.algorithms.arrays;

import java.util.Arrays;

public class ReplaceElementsWithGreatestFromRight {

    /* brute force approach */
    static int[] usingBruteForce(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length-1; i++) {
            int greatest = 0;
            for(int j=i+1; j<nums.length; j++) {
                if(nums[j]>greatest) {
                    greatest = nums[j];
                }
            }
            nums[i] = greatest;
        }

        nums[nums.length -1] = -1;
        return nums;
    }

    /* we start copying largest from right side*/
    static int[] copyLargestFromRightSide(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length -1] = -1;
        for(int i=nums.length-2; i>=0; i--) {
            ans[i] = Math.max(nums[i+1], ans[i+1]);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println("############### Brute force approach ######################");
        System.out.println(Arrays.toString(usingBruteForce(new int[] {17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(usingBruteForce(new int[] {400})));

        System.out.println("############### Copy from right side - efficient  ######################");
        System.out.println(Arrays.toString(copyLargestFromRightSide(new int[] {17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(copyLargestFromRightSide(new int[] {400})));
    }
}
