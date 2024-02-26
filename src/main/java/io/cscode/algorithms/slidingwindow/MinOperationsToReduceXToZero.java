package io.cscode.algorithms.slidingwindow;

import java.util.stream.IntStream;

public class MinOperationsToReduceXToZero {

    static int minOperations(int[] nums, int x) {
        int sum = IntStream.of(nums).sum();
        if(sum == x) {
            return nums.length;
        }
        int remainder = sum - x;

        int left =0;
        int right =0;
        int currentSum = 0;
        int longest = 0;

        while(right < nums.length) {
            currentSum += nums[right];
            while(currentSum >remainder && left<=right) {
                currentSum -= nums[left];
                left++;
            }
            if(currentSum == remainder) {
                longest = Math.max(right - left + 1, longest);
            }
            right++;
        }
        return longest > 0 ? nums.length - longest : -1;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println(minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));

    }
}
