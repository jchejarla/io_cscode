package io.cscode.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumII {

    static int[] twoSumII(int[] numbers, int target) {

        //since the array is sorted, we can use two pointers:
        // If sum is greater, move right pointer to left.
        // If sum is lesser, move left pointer to right.

        int left=0;
        int right=numbers.length-1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[] {left+1, right+1}; // +1 because the input array is 1- indexed
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumII(new int[] {2,7,11,15}, 9)));
    }

}
