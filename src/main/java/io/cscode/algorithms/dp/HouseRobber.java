package io.cscode.algorithms.dp;

import java.util.HashMap;

public class HouseRobber {

    /* Brute force approach*/
    static int bruteForceApproach(int[] nums) {
        return bruteForceApproachRec(nums, 0);
    }

    static int bruteForceApproachRec(int[] nums, int start) {
        if(start>=nums.length) {
            return 0;
        }
        return Math.max(nums[start] + bruteForceApproachRec(nums, start+2), bruteForceApproachRec(nums, start+1));
    }

    /* DP memoization */
    static int dpMemoizationApproach(int[] nums) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dpMemoizationApproachRec(nums, 0, cache);
    }

    static int dpMemoizationApproachRec(int[] nums, int start, HashMap<Integer, Integer> cache) {
        if(start>=nums.length) {
            return 0;
        }
        if(cache.containsKey(start)) {
            return cache.get(start);
        }
        int result = Math.max(nums[start] + bruteForceApproachRec(nums, start+2), bruteForceApproachRec(nums, start+1));
        cache.put(start, result);
        return result;
    }


    /* DP tabulation */
    static int dpTabulationApproach(int[] nums) {
        if(nums.length ==1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2] , dp[i-1]);
        }
       return Math.max(dp[dp.length-1], dp[dp.length-2]);
    }

    static int dpMemoryOptimized(int[] nums) {

        int m1= 0;
        int m2 = 0;

        for(int i=0; i<nums.length; i++) {
            int temp = Math.max(nums[i]+m1 , m2);
            m1 = m2;
            m2 = temp;
        }
        return m2;
    }

    public static void main(String[] args) {
        System.out.println(bruteForceApproach(new int[]{1, 2, 3, 1}));
        System.out.println(bruteForceApproach(new int[]{2, 1, 1, 2}));

        System.out.println(dpMemoizationApproach(new int[]{1, 2, 3, 1}));
        System.out.println(dpMemoizationApproach(new int[]{2, 1, 1, 2}));

        System.out.println(dpTabulationApproach(new int[]{1, 2, 3, 1}));
        System.out.println(dpTabulationApproach(new int[]{2, 1, 1, 2}));

        System.out.println(dpMemoryOptimized(new int[]{1, 2, 3, 1}));
        System.out.println(dpMemoryOptimized(new int[]{2, 1, 1, 2}));
    }
}
