package io.cscode.algorithms.dp;

public class MaximumProductSubArray {

    /* brute force approach*/
    static int bruteForceApproach(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i< nums.length; i++) {
            int maxProductAtI = 1; // initializing this with 1, because it's a neutral value for multiplication
            for(int j=i; j<nums.length; j++) {
                maxProductAtI = maxProductAtI * nums[j];
                max = Math.max(max, maxProductAtI);
            }
        }
        return max;
    }

    /* DP efficient approach*/
    static int dpApproach(int[] nums) {
        int result = nums[0];

        int max_so_far = result;
        int min_so_far = result;

        for(int i=1;i<nums.length; i++) {
            int temp = max_so_far * nums[i];
            max_so_far = Math.max(nums[i], Math.max(temp, min_so_far * nums[i]));
            min_so_far = Math.min(nums[i], Math.min(temp, min_so_far * nums[i]));
            result = Math.max(result, max_so_far);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("#################### Brute force approach ##############");
        System.out.println(bruteForceApproach(new int[]{2, 3, -2, 4}));
        System.out.println(bruteForceApproach(new int[]{-1}));
        System.out.println(bruteForceApproach(new int[]{-2, 0, -1}));
        System.out.println(bruteForceApproach(new int[]{0}));
        System.out.println(bruteForceApproach(new int[]{-2, -3}));
        System.out.println(bruteForceApproach(new int[]{0, 3, 2, -6}));
        System.out.println(bruteForceApproach(new int[]{0, 3, 0, 2, -6}));
        System.out.println(bruteForceApproach(new int[]{0, 3, 0, 4, -6}));

        System.out.println("#################### DP efficient approach ##############");
        System.out.println(dpApproach(new int[]{2, 3, -2, 4}));
        System.out.println(dpApproach(new int[]{-1}));
        System.out.println(dpApproach(new int[]{-2, 0, -1}));
        System.out.println(dpApproach(new int[]{0}));
        System.out.println(dpApproach(new int[]{-2, -3}));
        System.out.println(dpApproach(new int[]{0, 3, 2, -6}));
        System.out.println(dpApproach(new int[]{0, 3, 0, 2, -6}));
        System.out.println(dpApproach(new int[]{0, 3, 0, 4, -6}));

    }
}
