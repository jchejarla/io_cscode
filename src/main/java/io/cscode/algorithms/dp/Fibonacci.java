package io.cscode.algorithms.dp;

import java.util.HashMap;

public class Fibonacci {


    /* Fibonacci using memoization technique */
    static int fibUsingMemoization(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return fibUsingMemoizationRecursive(n, cache);
    }

    static int fibUsingMemoizationRecursive(int n, HashMap<Integer, Integer> cache) {
        if(n ==0 || n ==1) { // base cases
            return 1;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = fibUsingMemoizationRecursive(n-1, cache) + fibUsingMemoizationRecursive(n-2, cache);
        cache.put(n, result);
        return result;
    }

    /* Fibonacci using tabulation technique */
    static int fibonacciUsingTabulation(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    /* Fibonacci optimized solution */
    static int fibonacciOptimized(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for(int i=2; i<=n; i++) {
            int currentFib = prev1 + prev2;
            prev1 = prev2;
            prev2 = currentFib;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println(fibUsingMemoization(5));
        System.out.println(fibonacciUsingTabulation(5));
        System.out.println(fibonacciOptimized(5));
    }
}
