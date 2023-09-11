package io.cscode.algorithms.dp;

import java.util.HashMap;
import java.util.HashSet;

public class PartitionEqualSubsetSum {

    /* Brute force logic using recursion */
    static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            return canPartitionRecursive(nums, sum / 2);
        }
        return false;
    }

    static boolean canPartitionRecursive(int[] nums, int sum) {
        if (sum == 0) {
            // we have reached to a point where subset with give sum is possible
            return true;
        }

        if ((nums.length == 0 && sum > 0) || sum < 0) {
            // we have reached to a point where subset with give sum is not possible
            return false;
        }

        int[] remainder = new int[nums.length - 1];
        System.arraycopy(nums, 0, remainder, 0, remainder.length);

        return canPartitionRecursive(remainder, sum) || canPartitionRecursive(remainder, sum - nums[nums.length - 1]);

    }

    /* optimized logic using memoization */
    static boolean canPartitionUsingMemoization(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 0) {
            HashMap<String, Boolean> memoize = new HashMap<>();
            return canPartitionRecursive(nums, sum / 2);
        }
        return false;
    }

    static boolean canPartitionUsingMemoizationRec(int[] nums, int reminderArrayLength, int sum, HashMap<String, Boolean> cache) {

        if (sum == 0) {
            return true;
        }

        if ((reminderArrayLength == 0 && sum > 0) || sum < 0) {
            return false;
        }

        String key = reminderArrayLength + "-" + sum;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int reducedArrayLength = reminderArrayLength - 1;

        boolean ans = canPartitionUsingMemoizationRec(nums, reducedArrayLength, sum, cache)
                || canPartitionUsingMemoizationRec(nums, reducedArrayLength, sum - nums[reducedArrayLength], cache);
        cache.put(key, ans);
        return ans;
    }


    /* similar to above, but optimized */
    static boolean canPartitionOptimizedUsingDP(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % 2 == 0) {
            return canPartitionMemoryOptimizedUsingDP(nums, sum/2);
        }
        return false;
    }

    static boolean canPartitionMemoryOptimizedUsingDP(int[] nums, int sum) {
        HashSet<Integer> memoized = new HashSet<>();
        memoized.add(0);
        for(int i=0; i<nums.length; i++) {
            HashSet<Integer> nextSet = new HashSet<>();
            for(Integer val : memoized) {
                nextSet.add(val+nums[i]);
                nextSet.add(val);
            }
            memoized = nextSet;
        }
        return memoized.contains(sum);
    }

    public static void main(String[] args) {
        System.out.println(" ##### using brute force approach ####");
        System.out.println(canPartition(new int[]{1,5,11,5})); // prints true
        System.out.println(canPartition(new int[]{1,2,3,5})); //prints false
        System.out.println(canPartition(new int[]{5}));//prints false

        System.out.println(" ##### using memoized approach ####");
        System.out.println(canPartitionUsingMemoization(new int[]{1,5,11,5})); // prints true
        System.out.println(canPartitionUsingMemoization(new int[]{1,2,3,5})); //prints false
        System.out.println(canPartitionUsingMemoization(new int[]{5}));//prints false

        System.out.println(" ##### using memoized - memory optimized approach ####");
        System.out.println(canPartitionOptimizedUsingDP(new int[]{1,5,11,5})); // prints true
        System.out.println(canPartitionOptimizedUsingDP(new int[]{1,2,3,5})); //prints false
        System.out.println(canPartitionOptimizedUsingDP(new int[]{5}));//prints false
    }

}
