package io.cscode.algorithms.arrays;

public class NumberOfZeroFilledSubArrays {

    static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long count = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] ==0) {
                count++;
            } else {
                count =0;
            }
            result = result + count;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
    }
}
