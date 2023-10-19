package io.cscode.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {

    /* Brute force approach */
    static int bruteForceApproach(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (amount <0){
            return -1;
        }

        int min = -1;
        for(int i=0; i<coins.length; i++) {
            int remainder = amount-coins[i];
            int count = bruteForceApproach(coins, remainder);
            if(count >=0) {
                count++;
                if(min == -1 || count <min){
                    min = count;
                }
            }
        }
        return min;
    }

    /* DP memoization */
    static int dpMemoization(int[] coins, int amount) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        return dpMemoizationRec(coins, amount, cache);
    }

    static int dpMemoizationRec(int[] coins, int amount, HashMap<Integer, Integer> cache) {

        if (amount == 0) {
            return 0;
        }
        if (amount <0){
            return -1;
        }

        if(cache.containsKey(amount)) {
            return cache.get(amount);
        }

        int min = -1;
        for(int i=0; i<coins.length; i++) {
            int remainder = amount-coins[i];
            int count = bruteForceApproach(coins, remainder);
            if(count >=0) {
                count++;
                if(min == -1 || count <min){
                    min = count;
                }
            }
        }
        cache.put(amount, min);
        return min;
    }


    /* DP tabulation bottom-up approach */
    static int dpTabulation(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        cache[0] = 0;
        Arrays.fill(cache, 1, amount+1, amount+1); // fill the cache with amount +1
                                                                       // reason why we are using amount+1 as a way to indicate
                                                                       //whether we can make up the amount using coins not
        for(int i=1; i<cache.length; i++) {
            for(int coin : coins) {
                if(i-coin >=0) {
                    cache[i] = Math.min(cache[i], 1+ cache[i-coin]);
                }
            }
        }

        if(cache[amount] != amount+1) { // meaning that amount indexed element in cache
                                        // has different value than amount+1, what it is initialized with
            return cache[amount];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("#################### Brute force approach ##############");
        System.out.println(bruteForceApproach(new int[]{1,2,5}, 11));
        System.out.println(bruteForceApproach(new int[]{1,2,5}, 0));
        System.out.println(bruteForceApproach(new int[]{2}, 3));

        System.out.println("#################### DP memoization approach ##############");
        System.out.println(dpMemoization(new int[]{1,2,5}, 11));
        System.out.println(dpMemoization(new int[]{1,2,5}, 0));
        System.out.println(dpMemoization(new int[]{2}, 3));

        System.out.println("#################### DP tabulation ##############");
        System.out.println(dpTabulation(new int[]{1,2,5}, 11));
        System.out.println(dpTabulation(new int[]{1,2,5}, 0));
        System.out.println(dpTabulation(new int[]{2}, 3));

    }
}
