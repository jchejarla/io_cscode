package io.cscode.algorithms.dp;

import java.util.HashMap;

public class ClimbingStairs {

    /* brute force approach */
    static int climbStairsBruteForce(int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        return climbStairsBruteForce(n-1) + climbStairsBruteForce(n-2);
    }

    /* Using DP memoization*/
    static int climbStairsUsingMemoization(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return climbStairsUsingMemoizationRecursive(n, cache);
    }

    static int climbStairsUsingMemoizationRecursive(int n, HashMap<Integer, Integer> cache) {
        if(n == 0){
            return 1;
        }
        if(n < 0) {
            return 0;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        int result =  climbStairsBruteForce(n-1) + climbStairsBruteForce(n-2);
        cache.put(n, result);
        return result;
    }

    /* Using DP tabulation */
    static int climbStairsUsingTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /* Memory efficient */
    static int climbStairsMemoryEfficient(int n) {
       int prev = 1; // start at step 0
       int current = 1; // start at step 1
       for(int i=1; i<n; i++) {
        int temp = current;
        current = prev+current;
        prev = temp;
       }
       return current;
    }


    public static void main(String[] args) {
        System.out.println(climbStairsBruteForce(5));
        System.out.println(climbStairsUsingMemoization(5));
        System.out.println(climbStairsUsingTabulation(5));
        System.out.println(climbStairsMemoryEfficient(5));
    }


}
