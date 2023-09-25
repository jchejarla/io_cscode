package io.cscode.algorithms.dp;

import java.util.HashMap;

public class MinCostClimbingStairs {

    /* Brute force approach*/
    static int bruteForceApproach(int[] cost) {
        // we can start from index 0 or 1, so taking minimum from both outcomes
        return Math.min(bruteForceApproachRec(cost, 0), bruteForceApproachRec(cost, 1));
    }

    static int bruteForceApproachRec(int[] cost, int start) {
        if(start>=cost.length) { // base case, when we reach end of array or out of bounds
                                // as we are calling recursively with start+1 and start+2
            return 0;
        }
        return cost[start] + Math.min(bruteForceApproachRec(cost, start+1), bruteForceApproachRec(cost, start+2));
    }

    /* DP memoization*/
    static int dpMemoizationApproach(int[] cost) {
        // we can start from index 0 or 1, so taking minimum from both outcomes
        HashMap<Integer, Integer> cache = new HashMap<>();
        return Math.min(bruteForceApproachRec(cost, 0), bruteForceApproachRec(cost, 1));
    }

    static int dpMemoizationApproachRec(int[] cost, int start, HashMap<Integer, Integer> cache) {
        if(start>=cost.length) { // base case, when we reach end of array or out of bounds
            // as we are calling recursively with start+1 and start+2
            return 0;
        }
        if(cache.containsKey(start)) {
            return cache.get(start);
        }
        int result =  cost[start] + Math.min(bruteForceApproachRec(cost, start+1), bruteForceApproachRec(cost, start+2));
        cache.put(start, result);
        return result;
    }


    /* DP tabulation approach*/
    static int dpTabulationApproach(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i =2; i<cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[cost.length-1], dp[cost.length-2]);
    }

    /* DP tabulation approach memory optimized*/
    static int dpTabulationApproachMemoryOptimized(int[] cost) {
        int prev = cost[0];
        int current = cost[1];
        for (int i =2; i<cost.length; i++){
            int temp = cost[i] + Math.min(prev, current);
            prev = current;
            current = temp;
        }
        return Math.min(prev, current);
    }

    public static void main(String[] args) {
        System.out.println(bruteForceApproach(new int[]{1 ,100,1,1,1,100,1,1,100,1}));
        System.out.println(dpMemoizationApproach(new int[]{1 ,100,1,1,1,100,1,1,100,1}));
        System.out.println(dpTabulationApproach(new int[]{1 ,100,1,1,1,100,1,1,100,1}));
        System.out.println(dpTabulationApproachMemoryOptimized(new int[]{1 ,100,1,1,1,100,1,1,100,1}));
    }
}
