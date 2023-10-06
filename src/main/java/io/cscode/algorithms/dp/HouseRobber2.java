package io.cscode.algorithms.dp;

import java.util.HashMap;

public class HouseRobber2 {

    /* brute force approach*/
    static int bruteForceApproach(int[] nums) {
        int one = bruteForceApproachRec(nums, 0, nums.length-2);
        int two = bruteForceApproachRec(nums, 1, nums.length-1);
        return Math.max(one, two);
    }

    static int bruteForceApproachRec(int[] nums, int start, int end) {
        if(start>=nums.length) {
            return 0;
        }
        if(start > end) {
            return 0;
        }
        return Math.max(nums[start] + bruteForceApproachRec(nums, start+2, end), bruteForceApproachRec(nums, start+1, end));
    }


    /* DP memoization*/
    static int dpMemoizationApproach(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int one = dpMemoizationApproachRec(nums, 0, nums.length-2, cache);
        int two = dpMemoizationApproachRec(nums, 1, nums.length-1, cache);
        return Math.max(one, two);
    }

    static int dpMemoizationApproachRec(int[] nums, int start, int end, HashMap<Integer, Integer> cache) {
        if(start>=nums.length) {
            return 0;
        }
        if(start > end) {
            return 0;
        }
        if(cache.containsKey(start)) {
            return cache.get(start);
        }
        int result =  Math.max(nums[start] + bruteForceApproachRec(nums, start+2, end), bruteForceApproachRec(nums, start+1, end));
        cache.put(start, result);
        return result;
    }

    /* DP tabulation approach */
    static int dpTabulationApproach(int[] nums) {

        int[] excl_last_house = new int[nums.length -1];
        System.arraycopy(nums, 0, excl_last_house,0,nums.length-1);
        int max1 = dpTabulationApproachHelper(excl_last_house);

        int[] excl_first_house = new int[nums.length-1];
        System.arraycopy(nums,1,excl_first_house,0, nums.length-1);
        int max2 = dpTabulationApproachHelper(excl_first_house);

        return Math.max(max1, max2);
    }

    static int dpTabulationApproachHelper(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
    }

    /* DP optimized */
    static int dpOptimized(int[] nums) {

        int max1 = dpOptimizedHelper(nums, 0, nums.length-2); // excluding the last house
        int max2 = dpOptimizedHelper(nums, 1, nums.length-1); // excluding the first house

        return Math.max(max1, max2);
    }

    static int dpOptimizedHelper(int[] nums, int start, int end) {

        int m1 = 0;
        int m2 = 0;
        for(int i=start;i<=end; i++) {
            int temp = Math.max(nums[i]+m1, m2);
            m1 = m2;
            m2 = temp;
        }

        return m2;

    }

    public static void main(String[] args) {

        System.out.println("Brute force approach for array [2, 3, 2] : " +bruteForceApproach(new int []{2, 3, 2}));
        System.out.println("Brute force approach for array [1, 2, 3, 1] : " +bruteForceApproach(new int []{1, 2, 3, 1}));
        System.out.println("Brute force approach for array [1, 2, 3] : " +bruteForceApproach(new int []{1, 2, 3}));

        System.out.println("-------------------############----------------------------------------");

        System.out.println("DP memoization approach for array [2, 3, 2] : " +dpMemoizationApproach(new int []{2, 3, 2}));
        System.out.println("DP memoization approach for array [1, 2, 3, 1] : " +dpMemoizationApproach(new int []{1, 2, 3, 1}));
        System.out.println("DP memoization approach for array [1, 2, 3] : "+dpMemoizationApproach(new int []{1, 2, 3}));

        System.out.println("-------------------############----------------------------------------");

        System.out.println("DP tabulation approach for array [2, 3, 2] : " +dpTabulationApproach(new int []{2, 3, 2}));
        System.out.println("DP tabulation approach for array [1, 2, 3, 1] : " +dpTabulationApproach(new int []{1, 2, 3, 1}));
        System.out.println("DP tabulation approach for array [1, 2, 3] : "+dpTabulationApproach(new int []{1, 2, 3}));

        System.out.println("-------------------############----------------------------------------");

        System.out.println("DP optimized approach for array [2, 3, 2] : " +dpOptimized(new int []{2, 3, 2}));
        System.out.println("DP optimized approach for array [1, 2, 3, 1] : " +dpOptimized(new int []{1, 2, 3, 1}));
        System.out.println("DP optimized approach for array [1, 2, 3] : "+dpOptimized(new int []{1, 2, 3}));

    }
}
