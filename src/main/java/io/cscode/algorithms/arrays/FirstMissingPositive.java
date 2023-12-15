package io.cscode.algorithms.arrays;

public class FirstMissingPositive {

    static int firstMissingPositive(int[] nums) {

        // Mark numbers that are out of range, anything less than 0 and greater than N (length of nums) with n+1
        // because smallest positive number possible is 1, and if array has n-1 elements the
        // highest positive value possible is n (in case if array has 1....n),

        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] <=0 || nums[i]>n) {
                nums[i] = n + 1;
            }
        }

        // Mark the nums[i] as index in the array, to indicate that it present.
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i]);
            if(index <= n) {
                nums[index -1] = - Math.abs(nums[index -1]); // abs, in case it was already marked previously
            }
        }

        for(int i=0; i<n; i++) {
            if(nums[i] >0) {
                return i+1;
            }
        }

        return n+1; // if all numbers of present in array [0....n-1]

    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,2,0}));
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));

    }
}
